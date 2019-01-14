package com.example.subhash.subhashdeveloper;





import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {
    String BASE_URL="http://122.160.60.67/";
    @Headers("Content-Type: application/json")
    @POST("DoodValaApi/api/Cart/GetCartsByUserId")
    Call<JsonObject> getdata(@Body JsonObject jsonObject);
}
