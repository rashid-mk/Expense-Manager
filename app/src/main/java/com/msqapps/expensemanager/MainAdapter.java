package com.msqapps.expensemanager;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainAdapter extends FirebaseRecyclerAdapter<bookdata,MainAdapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    private ArrayList<bookdata> list;

    public MainAdapter(@NonNull FirebaseRecyclerOptions<bookdata> options, ArrayList<bookdata> list) {
        super(options);
        this.list = list;
    }

    private OnRecy listener;
    Context context;
    public interface OnRecy{
        void onItemClick(int position);
    }
    public void Onrecy(OnRecy listener){
        this.listener=listener;

    }
    public MainAdapter(@NonNull FirebaseRecyclerOptions<bookdata> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, @SuppressLint("RecyclerView") final int position, @NonNull bookdata model) {
        holder.name.setText(model.getName());



holder.del.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder  builder=new AlertDialog.Builder(holder.name.getContext());
        builder.setTitle("Are you Sure?");
        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(getRef(position).getKey()).removeValue();
                Toast.makeText(holder.name.getContext(), "Deleted successfully", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                Toast.makeText(holder.name.getContext(), "Cancelled", Toast.LENGTH_SHORT).show();

            }
        });
        builder.show();
    }
});

    }





    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.layout,parent,false);
        return new myViewHolder(view,listener);
    }

    class  myViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        TextView box;
        Button del;
    //RecyclerView recyclerView;
        public myViewHolder(@NonNull View itemView,OnRecy listener) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.newbook);
            del=(Button)itemView.findViewById(R.id.deletebook);
            // box = (TextView) itemView.findViewById(R.id.txtbox);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener!=null && getAbsoluteAdapterPosition()!=RecyclerView.NO_POSITION) {
                        listener.onItemClick(getAbsoluteAdapterPosition());

                    }

                }
            });


        }
    }

}
