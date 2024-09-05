package com.example.service;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.example.service.AirplaneModeReceiver;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class mainpage extends AppCompatActivity {
    private AirplaneModeReceiver airplaneModeReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        getSupportActionBar().hide();

        airplaneModeReceiver = new AirplaneModeReceiver();


        Intent signup=getIntent();
        Bundle result=signup.getExtras();
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();

        home home1=new home();
        fragmentTransaction1.replace(R.id.frame,home1);
        fragmentTransaction1.commit();


        BottomNavigationView bottom_navigation=findViewById(R.id.bottomnav);
        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId= item.getItemId();
                if(itemId==R.id.bottom_profile)
                {
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    profile profile1=new profile();
                    profile1.setArguments(result);

                    fragmentTransaction.replace(R.id.frame,profile1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }

                if(itemId==R.id.bottom_home)
                {
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    home home1=new home();
                    home1.setArguments(result);

                    fragmentTransaction.replace(R.id.frame,home1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }

                if(itemId==R.id.bottom_account)
                {
                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                    mech_productlist list=new mech_productlist();
                    list.setArguments(result);

                    fragmentTransaction.replace(R.id.frame,list);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();


                }

                return false;
            }
        });

       /* profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

                profile profile1=new profile();
                profile1.setArguments(result);

                fragmentTransaction.replace(R.id.frame,profile1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });*/
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
        // Unregister the BroadcastReceiver when the activity is paused
        unregisterReceiver(airplaneModeReceiver);
    }
}
