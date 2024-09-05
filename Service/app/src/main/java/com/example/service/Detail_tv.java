package com.example.service;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail_tv#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail_tv extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Detail_tv() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detail_tv.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail_tv newInstance(String param1, String param2) {
        Detail_tv fragment = new Detail_tv();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    EditText name,location,number;
    Button button;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_detail_tv, container, false);

        name=view.findViewById(R.id.w_name);
        location=view.findViewById(R.id.w_location);
        number=view.findViewById(R.id.w_number);
        button=view.findViewById(R.id.btn);
        Dbhelper dbhelper = new Dbhelper(getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name1=name.getText().toString();
                String location1=location.getText().toString();
                String number1=number.getText().toString();

                dbhelper.addContact(name1,location1,number1);

                FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1=fragmentManager.beginTransaction();

                home home1=new home();
                fragmentTransaction1.replace(R.id.frame,home1);
                fragmentTransaction1.commit();

            }
        });

        return view;
    }
}