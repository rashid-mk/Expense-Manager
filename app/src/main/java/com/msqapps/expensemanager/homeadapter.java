package com.msqapps.expensemanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class homeadapter extends RecyclerView.Adapter<homeadapter.myview> {
    Context context;
    ArrayList<bookdata> list;

    public homeadapter(Context context, ArrayList<bookdata> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public myview onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

     View v= LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
     return  new myview(v);
    }

    @Override
    public void onBindViewHolder(@NonNull myview holder, int position) {
        bookdata b= list.get(position);
        holder.bookname.setText(b.getName());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class myview extends RecyclerView.ViewHolder{
        TextView bookname;

        public myview(@NonNull View itemView) {
            super(itemView);
            bookname=itemView.findViewById(R.id.newbook);

        }
    }
}
