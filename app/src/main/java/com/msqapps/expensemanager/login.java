package com.msqapps.expensemanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity {
    private EditText email2;
    private FirebaseAuth mAuth;
    private EditText password2;
    private TextView fp;
    private TextView register;
    private Button login1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_login);
        register = findViewById(R.id.regi);
       fp=findViewById(R.id.passf);

        login1 = findViewById(R.id.login);
        login1.setBackgroundColor(Color.parseColor("#071480"));
        email2 = findViewById(R.id.email1);
        password2 = findViewById(R.id.password1);


        //forgot pass
        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,forgotpassword.class);
                startActivity(intent);
                finish();
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(login.this,MainActivity.class);
                startActivity(intent);
            }
        });
        login1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email1 = email2.getText().toString();
                String password1 = password2.getText().toString();

                if (TextUtils.isEmpty(email1)) {

                    email2.setError("please fill this email");

                    email2.requestFocus();

                    return;
                }

                if (TextUtils.isEmpty(password1)) {

                    password2.setError("please fill this password");
                    password2.requestFocus();
                    return;
                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(email1).matches()){
                    email2.setError("please enter a valid email");
                    email2.requestFocus();
                    return;

                }


                // signin existing user
                mAuth.signInWithEmailAndPassword(email1, password1)
                        .addOnCompleteListener(
                                new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(
                                            @NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()) {
                                            Toast.makeText(getApplicationContext(),
                                                            "Login successful!!",
                                                            Toast.LENGTH_LONG)
                                                    .show();

                                            // hide the progress bar


                                            // if sign-in is successful
                                            // intent to home activity
                                            Intent intent
                                                    = new Intent(login.this,
                                                    home.class);
                                            startActivity(intent);
                                            finish();
                                        } else {

                                            // sign-in failed
                                            Toast.makeText(getApplicationContext(),
                                                            "Login failed!!",
                                                            Toast.LENGTH_LONG)
                                                    .show();

                                            // hide the progress bar

                                        }
                                    }
                                });

            }
        });
        }
    }