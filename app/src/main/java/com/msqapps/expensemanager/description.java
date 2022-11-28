package com.msqapps.expensemanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

public class description extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;
    DescriptionAdapter mainAdapter1;
    MainAdapter mainAdapter;
    DatabaseReference mDatabase,data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
//        String p=getIntent().getStringExtra("po");
//        int pp=Integer.parseInt(p);
//        ArrayList<String> keydata = new ArrayList<>();
//        recyclerView=findViewById(R.id.cycle1);
//        recyclerView1=findViewById(R.id.cycle2);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_description);






//        FirebaseRecyclerOptions<descModel> options =
//                new FirebaseRecyclerOptions.Builder<descModel>()
//                        .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()), descModel.class)
//                        .build();
//        mainAdapter=new DescriptionAdapter(options);
//        recyclerView.setAdapter(mainAdapter);
 //           try{
//
//
//                 mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//                 FirebaseRecyclerOptions<bookdata> options =
//                         new FirebaseRecyclerOptions.Builder<bookdata>()
//                                 .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()), bookdata.class)
//                                 .build();
//                 mainAdapter=new MainAdapter(options);
//                 recyclerView.setAdapter(mainAdapter);
//                 mDatabase.addValueEventListener(new ValueEventListener() {
//                     @Override
//                     public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//
//                         for (DataSnapshot postSnapshot : snapshot.getChildren()){
//
//                             String o = postSnapshot.getKey();
//
//                             keydata.add(o);
//
//                             try{
//                                 FirebaseRecyclerOptions<descModel> options =
//                                         new FirebaseRecyclerOptions.Builder<descModel>()
//                                                 .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Food"), descModel.class)
//                                                 .build();
//                                 mainAdapter=new DescriptionAdapter(options);
//                                 recyclerView.setAdapter(mainAdapter);
//
//
//
//
//                             }
//                             catch (Exception e){
//
//                             }
//
//
//                         }
//
//                     }
//
//                     @Override
//                     public void onCancelled(@NonNull DatabaseError error) {
//
//                     }
//                 });
//
//
//             }
//             catch (Exception e){
//
//             }
//             data=FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Food");
//        FirebaseRecyclerOptions<descModel> options =
//                new FirebaseRecyclerOptions.Builder<descModel>()
//                        .setQuery(data, descModel.class)
//                        .build();
//        mainAdapter=new DescriptionAdapter(options);
//        recyclerView.setAdapter(mainAdapter);

  //  }
//    @Override
//    protected void onStart() {
//        super.onStart();
//        mainAdapter.startListening();
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        mainAdapter.stopListening();
  }
}