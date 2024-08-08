package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class foodDetails extends AppCompatActivity {

    ImageView imageView;
    TextView txtName,txtPrice;
    Button btnMin,btnMax, btnCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        imageView=findViewById(R.id.foodImage);
        txtName=findViewById(R.id.foodName);
        txtPrice=findViewById(R.id.foodPrice);
        btnMin=findViewById(R.id.dec);
        btnMax=findViewById(R.id.Add);
        btnCart=findViewById(R.id.addFood);
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String price=intent.getStringExtra("price");
        int img=intent.getIntExtra("image",1);


    }
}