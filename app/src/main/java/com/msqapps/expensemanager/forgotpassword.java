package com.msqapps.expensemanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgotpassword extends AppCompatActivity {
    private EditText email;
    private Button  btn;
    private ProgressBar p;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_forgotpassword);
        email=findViewById(R.id.femail);
        btn=findViewById(R.id.fbutton);
        btn.setBackgroundColor(Color.parseColor("#071480"));
        p=findViewById(R.id.progressBar);
        firebaseAuth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetpassword();
            }
        });
    }

    private void resetpassword() {
        String em=email.getText().toString().trim();
        if(em.isEmpty()){
            email.setError("Email required");
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(em).matches()){
            email.setError("please enter a valid email");
            email.requestFocus();
            return;
        }
        p.setVisibility(View.VISIBLE);

        firebaseAuth.sendPasswordResetEmail(em).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                   Toast.makeText(forgotpassword.this, "please check email", Toast.LENGTH_SHORT).show();
                    p.setVisibility(View.GONE);
              }
               else{
                   Toast.makeText(forgotpassword.this, "Enterd email is not registred", Toast.LENGTH_SHORT).show();
                    p.setVisibility(View.GONE);
              }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(forgotpassword.this,login.class);
        startActivity(intent);
        finish();
    }
}