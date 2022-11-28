package com.msqapps.expensemanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Map;



public class firstpage extends AppCompatActivity {
    private TextView text,totalf,totalr,totalm,totalt,totalo;
    private TextView text1,cinf,cinr,cinm,cint,cino;
    private TextView total,coutf,coutr,coutm,coutt,couto;
    public int sumf,totalsumf,summ,sumr,sumt,sumo,totalsumm,totalsumt,totalsumo,totalsumr,totalall,totalcashin,totalcashout;
    public int sumf2,summ2,sumr2,sumt2,sumo2;
    private TextView cf,cr,cm,ct,co,cof,cor,com,cot,coo;
    private Button cashin1,cashout;
    DatabaseReference mDatabase,data,newdata,secdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String p=getIntent().getStringExtra("pos");
        int pp=Integer.parseInt(p);

        setContentView(R.layout.activity_firstpage);

        cf=findViewById(R.id.cinf);
        cr=findViewById(R.id.cinr);
        cm=findViewById(R.id.cinm);
        ct=findViewById(R.id.cint);
        co=findViewById(R.id.cino);




        //cout

        cof=findViewById(R.id.coutf);
        cor=findViewById(R.id.coutr);
        com=findViewById(R.id.coutm);
        cot=findViewById(R.id.coutt);
        coo=findViewById(R.id.couto);




        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String f="Food";
                 String r="cash in";
                Intent intent=new Intent(firstpage.this,DescriptionActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat",f);
                intent.putExtra("cash",r);
                startActivity(intent);


            }
        });
        cof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Food";
                String r="cash out";
                Intent intent=new Intent(firstpage.this,DesccashoutActivity.class);
               intent.putExtra("po", p);
                intent.putExtra("cat1",f);
                intent.putExtra("cash",r);
                startActivity(intent);

            }
        });
        //Rent
        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Rent";
                String r="cash in";
                Intent intent=new Intent(firstpage.this,DescriptionActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat",f);
                intent.putExtra("cash",r);
                startActivity(intent);


            }
        });
        cor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Rent";
                String r="cash out";
                Intent intent=new Intent(firstpage.this,DesccashoutActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat1",f);
                intent.putExtra("cash",r);
                startActivity(intent);

            }
        });
// medicine

        cm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Medicine";
                String r="cash in";
                Intent intent=new Intent(firstpage.this,DescriptionActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat",f);
                intent.putExtra("cash",r);
                startActivity(intent);


            }
        });
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Medicine";
                String r="cash out";
                Intent intent=new Intent(firstpage.this,DesccashoutActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat1",f);
                intent.putExtra("cash",r);
                startActivity(intent);

            }
        });
        //Travel
        ct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Travel";
                String r="cash in";
                Intent intent=new Intent(firstpage.this,DescriptionActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat",f);
                intent.putExtra("cash",r);
                startActivity(intent);


            }
        });
        cot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Travel";
                String r="cash out";
                Intent intent=new Intent(firstpage.this,DesccashoutActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat1",f);
                intent.putExtra("cash",r);
                startActivity(intent);

            }
        });
//others
        co.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Others";
                String r="cash in";
                Intent intent=new Intent(firstpage.this,DescriptionActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat",f);
                intent.putExtra("cash",r);
                startActivity(intent);


            }
        });
        coo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String f="Others";
                String r="cash out";
                Intent intent=new Intent(firstpage.this,DesccashoutActivity.class);
                intent.putExtra("po", p);
                intent.putExtra("cat1",f);
                intent.putExtra("cash",r);
                startActivity(intent);

            }
        });




        cashin1=findViewById(R.id.cashin);
        text=findViewById(R.id.amt);
        total=findViewById(R.id.totamt);
        text1=findViewById(R.id.amt2);

        totalf=findViewById(R.id.totalf);
        totalr=findViewById(R.id.totalr);
        totalm=findViewById(R.id.totalm);
        totalt=findViewById(R.id.totalt);
        totalo=findViewById(R.id.totalo);

        cinf=findViewById(R.id.cashinf);
        cinr=findViewById(R.id.cashinr);
        cinm=findViewById(R.id.cashinm);
        cint=findViewById(R.id.cashint);
        cino=findViewById(R.id.cashino);

        coutf=findViewById(R.id.cashoutf);
        coutr=findViewById(R.id.cashoutr);
        coutm=findViewById(R.id.cashoutm);
        coutt=findViewById(R.id.cashoutt);
        couto=findViewById(R.id.cashouto);


        cashout=findViewById(R.id.cashout);
        cashin1.setBackgroundColor(Color.rgb(34,139,34));
        cashout.setBackgroundColor(Color.rgb(255,0,0));



        try {
            ArrayList<String> keydata = new ArrayList<>();
            ArrayList<String> keyid = new ArrayList<>();

            mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
            mDatabase.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {



                        // DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
                        String o = postSnapshot.getKey();

                        keydata.add(o);

                        int fg = keydata.indexOf(postSnapshot.getKey());



                       //food
                        try {

                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Food");


                            data.addValueEventListener(new ValueEventListener() {
                                int sum = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum += pValue;

                                       cinf.setText(String.valueOf(sum));


                                    }

                                    sumf=sum;
                                  //  Toast.makeText(firstpage.this,""+sum2, Toast.LENGTH_SHORT).show();


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        try {

                            newdata = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash out").child("Food");



                            newdata.addValueEventListener(new ValueEventListener() {
                                int sum1 = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum1 += pValue;
                                        coutf.setText(String.valueOf(sum1));


                                    }
                                    sumf2=sum1;
                                    totalsumf=sumf-sumf2;
                                    totalf.setText(String.valueOf(totalsumf));


                                }






                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

//                            Toast.makeText(firstpage.this,""+w, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        //rent
                        try {

                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Rent");


                            data.addValueEventListener(new ValueEventListener() {
                                int sum = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum += pValue;

                                        cinr.setText(String.valueOf(sum));

                                    }
                                    sumr=sum;
                                    //  Toast.makeText(firstpage.this,""+sum2, Toast.LENGTH_SHORT).show();


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        try {

                            newdata = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash out").child("Rent");



                            newdata.addValueEventListener(new ValueEventListener() {
                                int sum1 = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum1 += pValue;
                                        coutr.setText(String.valueOf(sum1));


                                    }
                                    sumr2=sum1;
                                    totalsumr=sumr-sumr2;
                                    totalr.setText(String.valueOf(totalsumr));


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

//                            Toast.makeText(firstpage.this,""+w, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        //medicine

                        try {

                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Medicine");


                            data.addValueEventListener(new ValueEventListener() {
                                int sum = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum += pValue;

                                        cinm.setText(String.valueOf(sum));

                                    }
                                    summ=sum;
                                    //  Toast.makeText(firstpage.this,""+sum2, Toast.LENGTH_SHORT).show();


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        try {

                            newdata = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash out").child("Medicine");



                            newdata.addValueEventListener(new ValueEventListener() {
                                int sum1 = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum1 += pValue;
                                        coutm.setText(String.valueOf(sum1));


                                    }
                                    summ2=sum1;
                                    totalsumm=summ-summ2;
                                    totalm.setText(String.valueOf(totalsumm));


                                }






                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

//                            Toast.makeText(firstpage.this,""+w, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        //travel
                        try {

                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Travel");


                            data.addValueEventListener(new ValueEventListener() {
                                int sum = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum += pValue;

                                        cint.setText(String.valueOf(sum));

                                    }
                                    sumt=sum;
                                    //  Toast.makeText(firstpage.this,""+sum2, Toast.LENGTH_SHORT).show();


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        try {

                            newdata = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash out").child("Travel");



                            newdata.addValueEventListener(new ValueEventListener() {
                                int sum1 = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum1 += pValue;
                                        coutt.setText(String.valueOf(sum1));


                                    }
                                    sumt2=sum1;
                                    totalsumt=sumt-sumt2;
                                    totalt.setText(String.valueOf(totalsumt));


                                }






                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

//                            Toast.makeText(firstpage.this,""+w, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }

   //others
                        try {

                            data = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash in").child("Others");


                            data.addValueEventListener(new ValueEventListener() {
                                int sum = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum += pValue;

                                        cino.setText(String.valueOf(sum));

                                    }
                                    sumo=sum;
                                    //  Toast.makeText(firstpage.this,""+sum2, Toast.LENGTH_SHORT).show();


                                }


                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });


                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }


                        try {

                            newdata = FirebaseDatabase.getInstance().getReference("books").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(keydata.get(pp)).child("cash out").child("Others");



                            newdata.addValueEventListener(new ValueEventListener() {
                                int sum1 = 0;

                                @Override
                                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                                        Map<String, Object> map = (Map<String, Object>) ds.getValue();
                                        Object price = map.get("amount");
                                        int pValue = Integer.parseInt(String.valueOf(price));
                                        sum1 += pValue;
                                        couto.setText(String.valueOf(sum1));


                                    }
                                    sumo2=sum1;
                                    totalsumo=sumo-sumo2;
                                    totalo.setText(String.valueOf(totalsumo));
                                    totalcashin=sumf+sumt+sumr+summ+sumo;
                                    text1.setText(String.valueOf(totalcashin));

                                    totalcashout=sumf2+sumt2+sumr2+summ2+sumo2;
                                    text.setText(String.valueOf(totalcashout));
                                    totalall=totalsumf+totalsumm+totalsumr+totalsumt+totalsumo;
                                    total.setText(String.valueOf(totalall));



                                }






                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {

                                }
                            });

//                            Toast.makeText(firstpage.this,""+w, Toast.LENGTH_SHORT).show();
                        } catch (Exception e) {
//                            Toast.makeText(firstpage.this, "NOT WORKIN", Toast.LENGTH_SHORT).show();

                        }





                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }


            });


        }catch (IndexOutOfBoundsException e){
            Toast.makeText(this, "error", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(firstpage.this, home.class);

            startActivity(intent);
            finish();
        }









       // Toast.makeText(this, ""+p, Toast.LENGTH_SHORT).show();

        cashin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(firstpage.this,cashin.class);
                intent.putExtra("posi",p);
                startActivity(intent);

            }
        });
        cashout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(firstpage.this,Cashout.class);
                intent.putExtra("posi",p);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(firstpage.this,home.class);
        startActivity(intent);
       finish();

    }
}