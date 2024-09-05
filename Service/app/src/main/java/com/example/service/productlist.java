

package com.example.service;
import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class productlist extends Fragment implements CustomAdapter.MessageSender {

    private static final int SMS_PERMISSION_REQUEST_CODE = 100;
    Dbhelper dbhelper;
    ArrayList<String> s_id,s_name,s_location,s_number;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;

    public void sendMessage(String phoneNumber, String message) {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.SEND_SMS}, SMS_PERMISSION_REQUEST_CODE);
        } else {

            Intent serviceIntent = new Intent(getActivity(), SMSService.class);
            serviceIntent.putExtra("phoneNumber", phoneNumber);
            serviceIntent.putExtra("message", message);
            getActivity().startService(serviceIntent);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == SMS_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

            } else {

                Toast.makeText(getActivity(), "SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_productlist, container, false);

        recyclerView=view.findViewById(R.id.recycle);
        dbhelper=new Dbhelper(getActivity());
        s_id=new ArrayList<>();
        s_name=new ArrayList<>();
        s_location=new ArrayList<>();
        s_number=new ArrayList<>();



        displaydata();
        CustomAdapter adapter = new CustomAdapter(getActivity(), s_id, s_name, s_location, s_number, this);
        recyclerView.setAdapter(adapter);




        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;
    }

    void displaydata()
    {
        Cursor cursor=dbhelper.readAllData();
        if(cursor.getCount()==0)
        {
            Toast.makeText(getActivity(), "no data", Toast.LENGTH_SHORT).show();
        }
        else
        {
            while(cursor.moveToNext())
            {
                s_id.add(cursor.getString(0));
                s_name.add(cursor.getString(1));
                s_location.add(cursor.getString(2));
                s_number.add(cursor.getString(3));


            }
        }
    }
}