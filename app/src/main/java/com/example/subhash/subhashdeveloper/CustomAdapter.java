package com.example.subhash.subhashdeveloper;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    Context context;
    ArrayList<Pojo> pojoList;

    public CustomAdapter(MainActivity mainActivity, ArrayList<Pojo> pojoArrayList) {
        this.context=mainActivity;
        this.pojoList=pojoArrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        Pojo pojo=pojoList.get(i);
        myViewHolder.name.setText(pojo.getName());
        myViewHolder.size.setText(pojo.getProduct_size());
        myViewHolder.quantity.setText(pojo.getQuantity());
        myViewHolder.s_price.setText(pojo.getPrice());
        myViewHolder.price.setText(pojo.getPrice());
        myViewHolder.time_stamp.setText(pojo.getTime_stamp());
        myViewHolder.tv_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Remove button on Testing", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.tv_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Minus button on Testing", Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.tv_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Plus button on Testing", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return pojoList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,size,quantity,s_price,price,time_stamp,tv_minus,tv_plus,tv_remove;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.tv_name);
            size=itemView.findViewById(R.id.tv_size);
            quantity=itemView.findViewById(R.id.tv_quan);
            s_price=itemView.findViewById(R.id.tv_tprice);
            price=itemView.findViewById(R.id.tv_price);
            time_stamp=itemView.findViewById(R.id.tv_time_stamp);
            tv_minus=itemView.findViewById(R.id.tv_quan_minus);
            tv_plus=itemView.findViewById(R.id.tv_quan_plus);
            tv_remove=itemView.findViewById(R.id.tv_remove);
            imageView=itemView.findViewById(R.id.image_view);

        }
    }
}
