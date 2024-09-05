package com.example.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class home extends Fragment {

    ImageView wash,two,three,four;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        wash=view.findViewById(R.id.image1);
        two=view.findViewById(R.id.image2);
        three=view.findViewById(R.id.image3);
        four=view.findViewById(R.id.image4);
        wash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.frame,new productlist());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.frame,new productlist());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.frame,new productlist());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.frame,new productlist());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();
            }
        });


        // Inflate the layout for this fragment
       /* tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle result=new Bundle();
                result.putString("tv","selected TV");
                getParentFragmentManager().setFragmentResult("product1",result);

                FragmentManager fragmentManager=requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();
                fragmentTransaction1.replace(R.id.frame,new productlist());
                fragmentTransaction1.addToBackStack(null);
                fragmentTransaction1.commit();

            }

        });*/

        return view;
    }
}