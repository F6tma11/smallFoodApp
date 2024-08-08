package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName,edtPassword;
    Button btnLogin;
    TextView tvSign;
    DataBase dataBase=new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName=findViewById(R.id.edittext);
        edtPassword=findViewById(R.id.edittext2);
        btnLogin=findViewById(R.id.loginbtn);
        tvSign=findViewById(R.id.txtsign);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag=dataBase.Login(edtName.getText().toString(),edtPassword.getText().toString());
                if(flag){
                    Intent intent=new Intent(MainActivity.this,OurMenu.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(MainActivity.this, "UserName or Password Incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });

    }
}