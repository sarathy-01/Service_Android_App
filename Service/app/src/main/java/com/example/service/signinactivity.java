package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.math.BigInteger;

public class signinactivity extends AppCompatActivity {
    Button b1;
    EditText username;
    EditText email;
    EditText mobile;
    EditText city;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signinactivity);
        getSupportActionBar().hide();
        b1=findViewById(R.id.signup1);
        username=findViewById(R.id.username);
        email=findViewById(R.id.email);
        mobile=findViewById(R.id.mobile);
        city=findViewById(R.id.city);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nametemp=username.getText().toString();
                Long mobiletemp=Long.parseLong(mobile.getText().toString());
                String emailtemp=email.getText().toString();
                String location=city.getText().toString();


                Bundle result = new Bundle();
                result.putString("username",nametemp);
                result.putString("email",emailtemp);
                result.putLong("mobile",mobiletemp);
                result.putString("location",location);
               /* profile profile=new profile();
                profile.setArguments(result);*/

                Intent signup1=new Intent(signinactivity.this,mainpage.class);
                signup1.putExtras(result);

                startActivity(signup1);


            }
        });
    }
    }
