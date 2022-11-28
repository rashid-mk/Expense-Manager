package com.msqapps.expensemanager;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class cashin extends AppCompatActivity {

    EditText amountt,descr;
    Button cashin;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat,simpleDateFormat1;
   bookdata bookdat;
    DatabaseReference  data;
    DatabaseReference  newdata;
    Spinner spinner;
    String dat,ti;
    private String catagory;
    String[] sp={"Food","Medicine","Rent","Travel","Others"};
    String[] sp1={"Food","Medicine","Rent","Travel","Others"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashin);
        amountt=(EditText) findViewById(R.id.amount);
        descr=(EditText) findViewById(R.id.des);
        cashin=(Button) findViewById(R.id.cash);


        ArrayAdapter<String> adapter=new ArrayAdapter<>(

                this,R.layout.drop_down_item,sp1
        );
        AutoCompleteTextView autoCompleteTextView=findViewById(R.id.cat);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                catagory=adapterView.getItemAtPosition(i).toString();

            }
        });



        String key="1";


      String p=getIntent().getStringExtra("posi");

       int pp=Integer.parseInt(p);

     int b=Integer.parseInt(key);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        String str=mDatabase.getKey();


        List<String> keys = null;
        ArrayList<bookdata> keyof=new ArrayList<bookdata>();
        ArrayList<String> keydata=new ArrayList<>();



  mDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override
      public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

          for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

         bookdata value=postSnapshot.getValue(bookdata.class);

              String f = postSnapshot.getKey();

              keydata.add(f);

           int fg= keydata.indexOf(postSnapshot.getKey());





            try{        cashin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    //amountt.setInputType(InputType.TYPE_CLASS_NUMBER);
                    String amount=amountt.getText().toString();

                    String descri=descr.getText().toString();
                    if (TextUtils.isEmpty(amount)) {

                        amountt.setError("please fill this this");

                        amountt.requestFocus();

                        return;
                    }

                    if (TextUtils.isEmpty(descri)) {

                        descr.setError("please fill this this");

                        descr.requestFocus();

                        return;
                    }



                 calendar=Calendar.getInstance();
                    simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy ");
                    simpleDateFormat1=new SimpleDateFormat("HH:mm ");
                    dat=simpleDateFormat.format(calendar.getTime());
                    ti=simpleDateFormat1.format(calendar.getTime());



                    data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child(catagory);

                    cash c=new cash(amount,catagory,descri,dat,ti);

                    data.push().setValue(c);
                    Toast.makeText(cashin.this, "Success", Toast.LENGTH_SHORT).show();
                    amountt.setText("");
                    descr.setText("");

                }
            });
            }
            catch (Exception e){

            }




          }
      }

      @Override
      public void onCancelled(@NonNull DatabaseError error) {

      }



  });

       String ff="hello";




    }


}