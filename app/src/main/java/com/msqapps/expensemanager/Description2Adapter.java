package com.msqapps.expensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Description2Adapter extends RecyclerView.Adapter<Description2Adapter.MyViewHolder> {
    Context context;
    ArrayList<descmodel1> list;


    public Description2Adapter(Context context, ArrayList<descmodel1> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public Description2Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.decs,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Description2Adapter.MyViewHolder holder, int position) {
        descmodel1 decsriptionmodel=list.get(position);
        holder.time1.setText(decsriptionmodel.getTime());
        holder.date1.setText(decsriptionmodel.getDate());
        holder.amount1.setText(decsriptionmodel.getAmount());
        holder.description1.setText(decsriptionmodel.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date1,time1,amount1,description1;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            date1=itemView.findViewById(R.id.date);
            time1=itemView.findViewById(R.id.time);
            amount1=itemView.findViewById(R.id.ammt);
            description1=itemView.findViewById(R.id.descri);


        }
    }
}
