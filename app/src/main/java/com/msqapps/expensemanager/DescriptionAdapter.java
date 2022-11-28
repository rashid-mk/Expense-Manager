package com.msqapps.expensemanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DescriptionAdapter extends RecyclerView.Adapter<DescriptionAdapter.MyViewHolder> {
    Context context;
    int pp;
    String cash;
    ArrayList<decsriptionmodel> list;


    public DescriptionAdapter(Context context, ArrayList<decsriptionmodel> list,int pp,String cash) {
        this.context = context;
        this.pp=pp;
        this.cash=cash;
        this.list = list;

    }
    private MainAdapter.OnRecy listener;
    public interface OnRecy{
        void onItemClick(int position);
    }
    public void Onrecy(MainAdapter.OnRecy listener){
        this.listener=listener;

    }

    @NonNull
    @Override
    public DescriptionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(context).inflate(R.layout.decs,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DescriptionAdapter.MyViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        decsriptionmodel decsriptionmodel = list.get(position);
        holder.time1.setText(decsriptionmodel.getTime());
        holder.date1.setText(decsriptionmodel.getDate());
        holder.amount1.setText(decsriptionmodel.getAmount());
String hj=decsriptionmodel.getCatagory();

        holder.description1.setText(decsriptionmodel.getDescription());






            //delete
            holder.del.setOnClickListener(new View.OnClickListener() {



                ArrayList<String> keydata = new ArrayList<>();
                ArrayList<String> keydat = new ArrayList<>();




                @Override
                public void onClick(View view) {
                    DatabaseReference db = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                    db.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                        outer:  for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                                String o = postSnapshot.getKey();

                                keydata.add(o);


                                   // String hj=decsriptionmodel.getCatagory();
                              //     Toast.makeText(context, ""+position, Toast.LENGTH_SHORT).show();

try {


                               DatabaseReference     mdat = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child(cash).child(hj);

    mdat.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {




            for (DataSnapshot stSnapshot : snapshot.getChildren()) {
                String p = stSnapshot.getKey();
                keydat.add(p);

                try {
                   // Toast.makeText(context, "" + keydat.get(position), Toast.LENGTH_SHORT).show();
                DatabaseReference mdataa = mdat.child(keydat.get(position));

                mdataa.setValue(null);
                Intent i=new Intent(context,firstpage.class);
                context.startActivity(i);


                break;

            }catch (Exception e){
        Toast.makeText(context, "asdasd", Toast.LENGTH_SHORT).show();
    }
            }



        }


        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });

}catch (Exception e){

}

                                break;
                     }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                }


            });

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView date1,time1,amount1,description1,cat;
        DatabaseReference mdata;

        Button del;
        public MyViewHolder(@NonNull View itemView) {

            super(itemView);

            date1=itemView.findViewById(R.id.date);
            time1=itemView.findViewById(R.id.time);
            amount1=itemView.findViewById(R.id.ammt);
            del=(Button)itemView.findViewById(R.id.btndelete);
            description1=itemView.findViewById(R.id.descri);


        }
    }
}
