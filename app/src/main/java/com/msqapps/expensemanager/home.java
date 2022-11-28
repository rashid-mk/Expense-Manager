package com.msqapps.expensemanager;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;

public class home extends AppCompatActivity  {
    private SearchView searchView;
    private AlertDialog.Builder builder;
    private AlertDialog dialog;
    EditText name;
    private EditText name1;
    private RadioGroup radioGroup;
    private DatabaseReference mDatabase,data;
    private FirebaseAuth mAuth;
    private Button save;
    private Button addbook;
    private Button open;
    private Button logout;
  int flag=0;
    int flag1=0;
    private Toast backtoast;
  private ImageView cancel1;
    private Button cancel;
   private RecyclerView recyclerView;
    MainAdapter mainAdapter;
FirebaseUser firebaseUser;
    DatabaseReference Database;
    private  long backpressedtime;

    private MenuItem item1;
    private Menu menu;
    private ArrayList<book> list;
  bookdata book=new bookdata();

        public boolean onCreateOptionsMenu(Menu menu) {
           getMenuInflater().inflate(R.menu.menulogout, menu);


            return true;
        }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerView=findViewById(R.id.cycle);

        searchView=findViewById(R.id.search);
        addbook = findViewById(R.id.addbook);

        cancel1=findViewById(R.id.cancel1);
        mAuth=FirebaseAuth.getInstance();
        firebaseUser=mAuth.getCurrentUser();











      recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());





    FirebaseRecyclerOptions<bookdata> options =
                new FirebaseRecyclerOptions.Builder<bookdata>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()), bookdata.class)
                        .build();
        mainAdapter=new MainAdapter(options);
        recyclerView.setAdapter(mainAdapter);

        mainAdapter.Onrecy(new MainAdapter.OnRecy() {
            @Override
            public void onItemClick(int position) {

               int n = position;
               String b=Integer.toString(n);
               String ab="hai";
           String str;
              //  str = recyclerView.getAdapter().getItem(position).toString();
                Intent intent=new Intent(home.this,firstpage.class);
                intent.putExtra("pos",b);
                startActivity(intent);
                finish();


              // Toast.makeText(home.this, "position"+position, Toast.LENGTH_SHORT).show();
            }
        });







        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String newText) {

                 newfun();
                fliterList(newText);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {


                newfun();

                fliterList(newText);

                return true;
            }
        });
        addbook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewContactDialog();
            }
        });
    }

    private void newfun() {
        FirebaseRecyclerOptions<bookdata> option =
                new FirebaseRecyclerOptions.Builder<bookdata>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()), bookdata.class)
                        .build();
        mainAdapter=new MainAdapter(option);
        recyclerView.setAdapter(mainAdapter);

        mainAdapter.Onrecy(new MainAdapter.OnRecy() {
            @Override
            public void onItemClick(int position) {

                int n = position;
                String b=Integer.toString(n);
                String ab="hai";
                String str;
                //  str = recyclerView.getAdapter().getItem(position).toString();
                Intent intent=new Intent(home.this,firstpage.class);
                intent.putExtra("pos",b);
                startActivity(intent);
                finish();


                // Toast.makeText(home.this, "position"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void fliterList(String text) {
        FirebaseRecyclerOptions<bookdata> options =
                new FirebaseRecyclerOptions.Builder<bookdata>()
                        .setQuery(FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).orderByChild("name").startAt(text).endAt(text+"~"), bookdata.class)
                        .build();

 mainAdapter=new MainAdapter(options);
 mainAdapter.startListening();
 recyclerView.setAdapter(mainAdapter);
        ArrayList<String> keydata = new ArrayList<>();
        mainAdapter.Onrecy(new MainAdapter.OnRecy() {
            @Override
            public void onItemClick(int position) {

                Database=FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());

                Database.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                            if (flag == 0) {
                                Map<String, Object> map = (Map<String, Object>) postSnapshot.getValue();
                                Object price = map.get("name");
                                String nam = price.toString();
                                keydata.add(nam);
                                int er = keydata.indexOf(text);
                                if(er==-1 && flag1==0 ){
                                    Toast.makeText(home.this, "Please enter valid book name", Toast.LENGTH_SHORT).show();
                                    flag1=1;

                                }


                                if (er != -1) {
                                    int n = position;
                                    String b = Integer.toString(er);
                                    String ab = "hai";
                                    String str;
                                    //  str = recyclerView.getAdapter().getItem(position).toString();
                                    Intent intent = new Intent(home.this, firstpage.class);
                                    intent.putExtra("pos", b);
                                    startActivity(intent);
                                    finish();
                                    flag = 1;
                                    break;

                                }
                                ;

                            }

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });







                // Toast.makeText(home.this, "position"+position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void createNewContactDialog(){
  builder=new AlertDialog.Builder(this);
  final View contactPopupView=getLayoutInflater().inflate(R.layout.popup,null);
      EditText  name=(EditText) contactPopupView.findViewById(R.id.bookname);
        radioGroup=(RadioGroup) contactPopupView.findViewById(R.id.radiogp);

        save=(Button) contactPopupView.findViewById(R.id.save);
        cancel1=(ImageView) contactPopupView.findViewById(R.id.cancel1);
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



                book bk=new book(bookna);
                mDatabase.push().setValue(bk);
                dialog.dismiss();
            }
        });
        cancel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //cancel
                dialog.dismiss();
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout1) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(home.this);
            builder.setTitle("Are you Sure?");
            builder.setPositiveButton("sign out", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(home.this, "SignOut successfully", Toast.LENGTH_SHORT).show();
                    FirebaseAuth.getInstance().signOut();
                    Intent intent = new Intent(home.this, splash.class);

                    startActivity(intent);

                }
            });
            builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int which) {
                    Toast.makeText(home.this, "Cancelled", Toast.LENGTH_SHORT).show();

                }
            });
            builder.show();


            return true;
        }// If we got here, the user's action was not recognized.
        // Invoke the superclass to handle it.
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainAdapter.stopListening();
    }

    @Override
    public void onBackPressed() {

        if (backpressedtime + 1000 > System.currentTimeMillis()) {
            backtoast.cancel();
            super.onBackPressed();
            return;
        }
        else {
         backtoast= Toast.makeText(getBaseContext(),"Press Back again to exit ",Toast.LENGTH_SHORT);
         backtoast.show();
        }

        backpressedtime = System.currentTimeMillis();
    }
    }
