package com.msqapps.expensemanager;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class DescriptionActivity2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    Description2Adapter descriptionAdapter2,descriptionAdapter1;


    DatabaseReference mDatabase, data;
    TextView date1, time1, amount1, description1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description2);

        String p = getIntent().getStringExtra("po");
        int pp = Integer.parseInt(p);


//        date1=(TextView)findViewById(R.id.date);
//        time1=(TextView)findViewById(R.id.time);
//        amount1=(TextView)findViewById(R.id.ammt);
//        description1=(TextView)findViewById(R.id.descri);


        ArrayList<String> keydata = new ArrayList<>();

        ArrayList<descmodel1> list;
        list = new ArrayList<>();
//        ArrayList<descmodel1> list1;
//        list1 = new ArrayList<>();

        recyclerView = findViewById(R.id.recycle2);
        //  recyclerView1 = findViewById(R.id.recycle2);


        //  recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        descriptionAdapter2 = new Description2Adapter(this, list);
        //  descriptionAdapter1 = new DescriptionAdapter(this, list);
        recyclerView.setAdapter(descriptionAdapter2);
        // recyclerView1.setAdapter(descriptionAdapter1);


        mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        //data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child("N5owoTP_wI26clFxrMx").child("cash in").child("Food");

        try {
            //  Toast.makeText(DescriptionActivity.this, "sdfsdf", Toast.LENGTH_SHORT).show();

            mDatabase.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {

                        String o = postSnapshot.getKey();
                        keydata.add(o);


                        //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg"+keydata.get(pp), Toast.LENGTH_SHORT).show();


                        try {
                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Food");


                            recyclerView.setHasFixedSize(true);

                            data.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    // Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();

                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
//                                        decsriptionmodel des = dataSnapshot.getValue(decsriptionmodel.class);
//
//                                        list.add(des);

                                        Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                                        Object amt = map.get("amount");
                                        Object time=map.get("time");
                                        Object date=map.get("date");
                                        Object description=map.get("description");
                                        String time1=time.toString();
                                        String amt1=amt.toString();
                                        String date1=date.toString();
                                        String description1=description.toString();
                                        //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();

                                        descmodel1 descmodel1=new descmodel1(description1,amt1,time1,date1);
                                        list.add(descmodel1);



                                    }
                                    descriptionAdapter2.notifyDataSetChanged();
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


//

                        } catch (Exception e) {

                            //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg"+keydata.get(1), Toast.LENGTH_SHORT).show();


                        }


                    }


                }


                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


            // Toast.makeText(this, "cgh"+keydata.get(0), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {

            //    Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();

        }


        //cash out

//
//        try {
//            //  Toast.makeText(DescriptionActivity.this, "sdfsdf", Toast.LENGTH_SHORT).show();
//
//            mDatabase.addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    for (DataSnapshot postSnapshot : snapshot.getChildren()) {
//
//                        String o = postSnapshot.getKey();
//                        keydata.add(o);
//
//
//                        //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg"+keydata.get(pp), Toast.LENGTH_SHORT).show();
//
//
//                        try {
//                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Food");
//
//
//                            recyclerView.setHasFixedSize(true);
//
//                            data.addValueEventListener(new ValueEventListener() {
//                                @Override
//                                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                                    // Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();
//
//                                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
////                                        decsriptionmodel des = dataSnapshot.getValue(decsriptionmodel.class);
////
////                                        list.add(des);
//
//                                        Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
//                                        Object amt = map.get("amount");
//                                        Object time=map.get("time");
//                                        Object date=map.get("date");
//                                        Object description=map.get("description");
//                                        String time1=time.toString();
//                                        String amt1=amt.toString();
//                                        String date1=date.toString();
//                                        String description1=description.toString();
//                                        //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();
//
//                                        decsriptionmodel decsriptionmodel=new decsriptionmodel(description1,amt1,time1,date1);
//                                        list.add(decsriptionmodel);
//
//
//
//                                    }
//                                    descriptionAdapter1.notifyDataSetChanged();
//                                }
//
//                                @Override
//                                public void onCancelled(@NonNull DatabaseError error) {
//
//                                }
//                            });
//
//
////
//
//                        } catch (Exception e) {
//
//                            //  Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg"+keydata.get(1), Toast.LENGTH_SHORT).show();
//
//
//                        }
//
//
//                    }
//
//
//                }
//
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
//
//
//            // Toast.makeText(this, "cgh"+keydata.get(0), Toast.LENGTH_SHORT).show();
//        } catch (Exception e) {
//
//            //    Toast.makeText(DescriptionActivity.this, "gfdfgdfgdfg", Toast.LENGTH_SHORT).show();
//
//        }








    }



}
