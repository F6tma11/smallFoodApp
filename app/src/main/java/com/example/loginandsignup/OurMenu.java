package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class OurMenu extends AppCompatActivity {

    RecyclerView productList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_our_menu);
        ArrayList<Food>foodlist=new ArrayList<>();
        foodlist.add(new Food("Burger","60$",R.mipmap.burger));
        foodlist.add(new Food("Big Burger","100$",R.mipmap.burger_juce));
        foodlist.add(new Food("Fast Food","80$",R.mipmap.fast_food));
        foodlist.add(new Food("Dount","30$",R.mipmap.donut));
        foodlist.add(new Food("Larger Burger","150$",R.mipmap.fast_foodbig));
        foodlist.add(new Food("French Fries","45$",R.mipmap.french_fries));
        foodlist.add(new Food("Fried Chicken","65$",R.mipmap.fried_chicken));
        foodlist.add(new Food("Kebab","60$",R.mipmap.kebab));
        foodlist.add(new Food("Noodles","30$",R.mipmap.noodles));
        foodlist.add(new Food("Pizza","75$",R.mipmap.pizza));
        foodlist.add(new Food("Sandwich","60$",R.mipmap.sandwich));
        foodlist.add(new Food("Taco","60$",R.mipmap.taco));


        productList=findViewById(R.id.productView);
        FoodRecycle foodRecycle=new FoodRecycle(foodlist,this);
        productList.setLayoutManager(new GridLayoutManager(this,2));
        productList.setHasFixedSize(true);
        productList.setAdapter(foodRecycle);
    }
}