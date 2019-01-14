package com.example.subhash.subhashdeveloper;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    CustomAdapter customAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_view);
            getData();

    }

    private void getData() {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();
        Api api=retrofit.create(Api.class);
        final ArrayList<Pojo> pojoArrayList=new ArrayList<>();
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("RoleId", "3");
        jsonObject.addProperty("UserId", "8");
        Call<JsonObject> call=api.getdata(jsonObject);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                Toast.makeText(MainActivity.this, ""+response.body().toString(), Toast.LENGTH_SHORT).show();
                progressDialog.hide();
                String json=response.body().toString();
                JSONObject jsonObject1 = null;
                String status = null;
                try {
                    jsonObject1 =new JSONObject(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    status=jsonObject1.getString("Status");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                if (status.equals("200")) {

                    try {
                        JSONArray jsonArray = jsonObject1.getJSONArray("Data");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject c = jsonArray.getJSONObject(i);
                            String name = c.getString("Title");
                            String selling_price = c.getString("SellingPrice");
                            String size = c.getString("PackageSizeName");
                            String time_stamp = c.getString("TempStartedDate");
                            String quantity = c.getString("StockQuantity");
                            String strDate = time_stamp;

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                            Date date = null;
                            try {
                                date = dateFormat.parse(strDate);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                            dateFormat = new SimpleDateFormat("dd MMM yyyy");
                            System.out.println("Date :" + dateFormat.format(date));
                            String rs=getString(R.string.rupess);
                            Pojo pojo = new Pojo(name, rs+selling_price, size, dateFormat.format(date), quantity);
                            pojoArrayList.add(pojo);
                        }

                        customAdapter = new CustomAdapter(MainActivity.this,pojoArrayList);
                        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
                        recyclerView.setLayoutManager(mLayoutManager);
                        recyclerView.setItemAnimator(new DefaultItemAnimator());
                        recyclerView.setAdapter(customAdapter);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Status error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                progressDialog.hide();
                Toast.makeText(MainActivity.this, ""+t.toString(), Toast.LENGTH_SHORT).show();

            }
        });


    }
}
