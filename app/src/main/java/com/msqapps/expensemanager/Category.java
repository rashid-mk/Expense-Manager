package com.msqapps.expensemanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Category extends AppCompatActivity  {
    private SearchView searchView;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    EditText name;
    private EditText name1;
    private RadioGroup radioGroup;
    private DatabaseReference mDatabase,data;
    private FirebaseAuth mAuth;
    private Button save;
    private Button addcat;
    private Button open;

    private Button cancel;
    private RecyclerView recyclerView;
    categoryadapter catadapter;



    private ArrayList<book> list;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=findViewById(R.id.recyclerView);

       // open=findViewById(R.id.open);
     //   searchView=findViewById(R.id.search);
        addcat = findViewById(R.id.cat);

        String p=getIntent().getStringExtra("pos");

        int pp=Integer.parseInt(p);



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
//        String str=mDatabase.getKey();
//        data=FirebaseDatabase.getInstance().getReference(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(str);
        ArrayList<String> keydata=new ArrayList<>();
        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                    String f = postSnapshot.getKey();

                    keydata.add(f);
                    try{


                        data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in");

//                        FirebaseRecyclerOptions<addcateo> options =
//                                new FirebaseRecyclerOptions.Builder<addcateo>()
//                                        .setQuery(data, addcateo.class)
//                                        .build();
//                        catadapter=new categoryadapter(options);
//                        recyclerView.setAdapter(catadapter);

                    }


                    catch (Exception e){

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



        FirebaseRecyclerOptions<addcateo> options =
                new FirebaseRecyclerOptions.Builder<addcateo>()
                        .setQuery(data, addcateo.class)
                        .build();
        catadapter=new categoryadapter(options);
        recyclerView.setAdapter(catadapter);

//        catadapter.Onrecy(new categoryadapter().OnRecy() {
//            @Override
//            public void onItemClick(int position) {
//
//                int n = position;
//                String b=Integer.toString(n);
//                String ab="hai";
//                String str;
//                //  str = recyclerView.getAdapter().getItem(position).toString();
//                Intent intent=new Intent(Category.this,firstpage.class);
//                intent.putExtra("pos",b);
//                startActivity(intent);
//                Toast.makeText(Category.this, "position"+position, Toast.LENGTH_SHORT).show();
//            }
//        });

//        ArrayList<String> keydata=new ArrayList<>();
//        mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
//                    String f = postSnapshot.getKey();
//
//                    keydata.add(f);
//                    try{
//
//
//                        data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in");
//                    }
//                    catch (Exception e){
//
//                    }
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });









//        searchView.clearFocus();
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return true;
//            }
//        });
        addcat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }
        });
  }
    public void createNewContactDialog(){
        builder=new AlertDialog.Builder(this);
        final View contactPopupView=getLayoutInflater().inflate(R.layout.popup,null);
        EditText  name=(EditText) contactPopupView.findViewById(R.id.bookname);
        radioGroup=(RadioGroup) contactPopupView.findViewById(R.id.radiogp);

        save=(Button) contactPopupView.findViewById(R.id.save);
    //    cancel=(Button) contactPopupView.findViewById(R.id.cancel);
        builder.setView(contactPopupView);
        dialog=builder.create();
        dialog.show();



        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txtbook=name.getText().toString();
                inserbook(txtbook);


            }

            private void inserbook(String bookna) {



                addcateo bk=new addcateo(bookna);
                data.push().setValue(bk);
                dialog.dismiss();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel
                dialog.dismiss();
            }
        });




    }



    @Override
    protected void onStart() {
        super.onStart();
        catadapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        catadapter.stopListening();
    }



}