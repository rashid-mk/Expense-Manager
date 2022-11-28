package com.msqapps.expensemanager;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class splash2 extends AppCompatActivity {
long delay=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);
       // requestWindowFeature(Window.FEATURE_NO_TITLE);
       // this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        Timer t = new Timer();
       // mAuth = FirebaseAuth.getInstance();

        TimerTask tt = new TimerTask() {



            public void run() {
               Intent i = new Intent(splash2.this, splash.class);
               startActivity(i);
               finish();
            }
        };
        t.schedule(tt, delay);

    }
    }
