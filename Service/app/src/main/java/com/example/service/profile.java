package com.example.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class profile extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view=inflater.inflate(R.layout.fragment_profile, container, false);
       TextView name1,name2,mobile,mail,location;
       name1=view.findViewById(R.id.name_head_profile);
       name2=view.findViewById(R.id.name_profile);
       mobile=view.findViewById(R.id.mobile_profile);
       mail=view.findViewById(R.id.mail_profile);
       location=view.findViewById(R.id.loacation_profile);

       Bundle result=getArguments();
       name1.setText(result.getString("username"));
       name2.setText(result.getString("username"));
        mobile.setText(String.valueOf(result.getLong("mobile")));
         mail.setText(result.getString("email"));
       location.setText(result.getString("location"));

     /*  TextView et=view.findViewById(R.id.one);
       Bundle result=getArguments();
        String name=result.getString("username");
       et.setText(name);
*/





        return view;
    }
}