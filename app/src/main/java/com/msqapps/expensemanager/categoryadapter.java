package com.msqapps.expensemanager;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import java.util.ArrayList;

public class categoryadapter extends FirebaseRecyclerAdapter<addcateo,categoryadapter.myViewHolder> {


    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    private ArrayList<addcateo> list;

    public categoryadapter(@NonNull FirebaseRecyclerOptions<addcateo> options, ArrayList<addcateo> list) {
        super(options);
        this.list = list;
    }

    private OnRecy listener;
    Context context;



    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull addcateo model) {
        holder.name.setText(model.getCategory());
    }

    public interface OnRecy{
        void onItemClick(int position);
    }
    public void Onrecy(OnRecy listener){
        this.listener=listener;

    }
    public categoryadapter(@NonNull FirebaseRecyclerOptions<addcateo> options) {
        super(options);
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
        //RecyclerView recyclerView;
        public myViewHolder(@NonNull View itemView,OnRecy listener) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.newbook);
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
