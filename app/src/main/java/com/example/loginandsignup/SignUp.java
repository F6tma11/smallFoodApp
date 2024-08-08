package com.example.loginandsignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {

    EditText edtName,edtEmail,EdtPasword;
    Button btnSign;
    TextView tvLogin;
    DataBase dataBase=new DataBase(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        edtName=findViewById(R.id.edtname);
        edtEmail=findViewById(R.id.edtnum);
        EdtPasword=findViewById(R.id.edtpassword);
        btnSign=findViewById(R.id.btnSign);
        tvLogin=findViewById(R.id.txtlog);
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean flag=dataBase.insertCustomer(edtName.getText().toString(),
                        edtEmail.getText().toString(),EdtPasword.getText().toString());
                if(flag){
                    Toast.makeText(SignUp.this, "You Already have an account", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(SignUp.this, "Error occure please wait some time", Toast.LENGTH_SHORT).show();
                }
            }
        });
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}