package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.service.AirplaneModeReceiver;


public class MainActivity extends AppCompatActivity {
    private AirplaneModeReceiver airplaneModeReceiver;
    Button b1,b2;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

       imageView=findViewById(R.id.imagelogo);
        airplaneModeReceiver = new AirplaneModeReceiver();

        startAnimation();
        b1=findViewById(R.id.login);
        b2=findViewById(R.id.signup);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login=new Intent(MainActivity.this,Loginactivity.class);
                startActivity(login);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signup=new Intent(MainActivity.this,signinactivity.class);
                startActivity(signup);
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        // Register the BroadcastReceiver to listen for airplane mode changes
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeReceiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        unregisterReceiver(airplaneModeReceiver);
    }

    private void startAnimation() {

        RotateAnimation rotateAnimation = new RotateAnimation(
                0, 360,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f
        );

        rotateAnimation.setDuration(15000);
        rotateAnimation.setRepeatCount(Animation.INFINITE);


        imageView.startAnimation(rotateAnimation);
    }

}