package com.example.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.Viewhoder> {

    List<Food> foodList;
    ClickFood clickFood;
    Context context;
    SharedPreferences sharedPreferences;

    public AdapterFood(List<Food> foodList, Context context) {
        this.foodList = foodList;
        this.clickFood = clickFood;
        this.context = context;
        this.sharedPreferences = sharedPreferences;
    }


    @NonNull
    @Override
    public Viewhoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_food, parent, false);

        Viewhoder viewhoder = new Viewhoder(view);
        return viewhoder;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewhoder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class Viewhoder extends RecyclerView.ViewHolder {
        TextView tvname, tvprice;
        public Viewhoder(@NonNull View itemView) {
            super(itemView);

            tvname = itemView.findViewById(R.id.tvn);
            tvprice= itemView.findViewById(R.id.tvp);
        }
    }
}
