package com.msqapps.expensemanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Timer;
import java.util.TimerTask;

public class splash extends AppCompatActivity {
    long delay=2000;
    FirebaseAuth mAuth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Timer t = new Timer();
        mAuth = FirebaseAuth.getInstance();

        TimerTask tt = new TimerTask() {



            public void run() {
//                Intent i = new Intent(splash.this, login.class);
//                startActivity(i);
//                finish();
            }
        };
        t.schedule(tt, delay);

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser m=mAuth.getCurrentUser();
        if(m!=null){
            Intent i=new Intent(splash.this,home.class);
            startActivity(i);
            finish();
        }
        else{
            Intent i = new Intent(splash.this, login.class);
              startActivity(i);
                finish();
        }

    }


    }



