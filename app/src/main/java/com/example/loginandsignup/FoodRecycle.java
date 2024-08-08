package com.example.loginandsignup;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class FoodRecycle extends RecyclerView.Adapter<FoodRecycle.FoodViewHolder> {

    ArrayList<Food> FoodList;
    Context contex;

    public FoodRecycle(ArrayList<Food> foodList,Context context) {
        FoodList = foodList;
        context=contex;
    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_row,null,false);
        FoodViewHolder foodViewHolder=new FoodViewHolder(v);
        return foodViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

        Food food=FoodList.get(position);

        holder.name.setText(food.getName());
        holder.price.setText(food.getPrice());
        holder.image.setImageResource(food.getImg());

        holder.foodCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(contex,foodDetails.class);
                intent.putExtra("name",food.getName());
                intent.putExtra("price",food.getPrice());
                intent.putExtra("image",food.getImg());
                contex.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return FoodList.size();
    }

    class FoodViewHolder extends RecyclerView.ViewHolder{

        TextView name,price;
        ImageView image;
        CardView foodCard;
        public FoodViewHolder(@NonNull View itemView) {
            super(itemView);
            foodCard=itemView.findViewById(R.id.foodCard);
            name=itemView.findViewById(R.id.tvname);
            price=itemView.findViewById(R.id.tvprice);
            image=itemView.findViewById(R.id.imgFood);
        }
    }

}
