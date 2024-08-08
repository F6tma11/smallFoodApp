package com.example.loginandsignup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataBase extends SQLiteOpenHelper {

    public DataBase(@Nullable Context context) {
        super(context, "FoodShop.dp", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("Create Table custumer (id  INTEGER PRIMARY KEY AUTOINCREMENT,  userName Text, PhonNumber TEXT, password TEXT )");
        sqLiteDatabase.execSQL("create table foods(id INTEGER PRIMARY KEY AUTOINCREMENT, image blod NOT NULL , name TEXT , price TEXT)");
        sqLiteDatabase.execSQL("insert into foods values(@mipmap/burger_juce,BigBurger,60) ");
        sqLiteDatabase.execSQL("insert into foods values(@mipmap/burger,Burger,60) ");



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean insertCustomer(String name, String PhonNumber, String Password){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues cont=new ContentValues();
        cont.put("userName",name);
        cont.put("PhonNumber",PhonNumber);
        cont.put("password",Password);
        long flag=database.insert("custumer",null,cont);

        if(flag==-1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean Login(String username , String Password){
        SQLiteDatabase database=this.getReadableDatabase();
        Cursor curs=database.rawQuery("Select * from custumer where userName=? and password=?",new String[]{username,Password});
        if(curs.getCount()==0){
            return false;
        }else{
            return true;
        }

//        public ArrayList<Food> getAllData(){
//            SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
//            Cursor cursor=sqLiteDatabase.rawQuery("select * from foods",null);
//            if(cursor.getCount()==0){
//
//            }else {
//
//            }
//        }
    }
}
