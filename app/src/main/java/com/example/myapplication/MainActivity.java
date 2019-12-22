package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Food> foodList;
    RecyclerView recyclerView;
    View vadd;

    AdapterFood adapterFood;
    int mPosition = -1;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvList);
        vadd = findViewById(R.id.vadd);
        foodList = new ArrayList<>();

        preferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        editor = preferences.edit();

        foodList.add(new Food("Pizza Panda","10$"));
        foodList.add(new Food("KFC Super","15$"));
        foodList.add(new Food("Bread eggs","5$"));
        foodList.add(new Food("Coca Cola","5$"));
        foodList.add(new Food("Chicken Super","20$"));
        foodList.add(new Food("Cup cake","5$"));


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getBaseContext(),
                LinearLayoutManager.VERTICAL, false);

        adapterFood = new AdapterFood(foodList,getBaseContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterFood);

        recyclerView.setOnClickListener(new AdapterView.OnClickListener() {
            @Override
            public void onClick(View view) {

            }

            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String name = foodList.get(i).getName();
                String price = foodList.get(i).getPrice();
                Toast.makeText(getBaseContext(),"Name: "+name+ "\n"+"price: "+price ,Toast.LENGTH_LONG).show();
            }
        });

    }
}
