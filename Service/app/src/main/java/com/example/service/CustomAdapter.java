package com.example.service;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<String> s_id,s_name,s_location,s_number;


    public interface MessageSender {
        void sendMessage(String phoneNumber, String message);
    }

    private MessageSender messageSender;

    CustomAdapter(Context context,ArrayList s_id,ArrayList s_name,ArrayList s_location,ArrayList s_number, MessageSender messageSender)
    {
        this.context=context;
        this.s_id=s_id;
        this.s_name=s_name;
        this.s_location=s_location;
        this.s_number=s_number;
        this.messageSender = messageSender;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.my_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.idid.setText(String.valueOf(s_id.get(position)));
        holder.idname.setText(String.valueOf(s_name.get(position)));
        holder.idlocation.setText(String.valueOf(s_location.get(position)));
        holder.idnumber.setText(String.valueOf(s_number.get(position)));


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int clickedPosition = holder.getAdapterPosition();

                if (clickedPosition != RecyclerView.NO_POSITION) {

                    String phoneNumber = s_number.get(clickedPosition);

                    String message = "Hello, I would like to request your services. Please call me at your earliest convenience. Thank you.";


                    messageSender.sendMessage(phoneNumber, message);
                    Toast.makeText(context, "Selected: " + s_name.get(clickedPosition), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    @Override
    public int getItemCount() {

        return s_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView idid,idname,idlocation,idnumber;
        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            idid=itemView.findViewById(R.id.r_id);
            idname=itemView.findViewById(R.id.r_name);
            idnumber=itemView.findViewById(R.id.r_number);
            idlocation=itemView.findViewById(R.id.r_location);
        }
    }
}