package com.msqapps.expensemanager;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
     FirebaseDatabase mDatabase;
    DatabaseReference reference;

    private FirebaseAuth mAuth;
    private EditText email;
    private EditText name;
    private EditText password;
    private Button register;
    private EditText name1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        mDatabase = FirebaseDatabase.getInstance();
        reference=mDatabase.getReference("users");


        mAuth = FirebaseAuth.getInstance();
        register = findViewById(R.id.button);
        register.setBackgroundColor(Color.parseColor("#071480"));

        name = findViewById(R.id.name3);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        mAuth=FirebaseAuth.getInstance();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String txt_email = email.getText().toString();
                String txt_password = password.getText().toString();
                String txt_name = name.getText().toString();

                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password) || TextUtils.isEmpty(txt_name)) {
                    Toast.makeText(MainActivity.this, "Empty Credentials!", Toast.LENGTH_SHORT).show();
                    email.setError("please fill this email");
                    password.setError("please fill this password");
                    name.setError("please fill this name");
                    email.requestFocus();
                    password.requestFocus();
                    name.requestFocus();
                    return;

                }else if(!Patterns.EMAIL_ADDRESS.matcher(txt_email).matches()){
                    email.setError("please enter a valid email");
                    email.requestFocus();
                    return;

                }else if(txt_password.length()<8){
                    password.setError("charecters must be greater than seven");
                    password.requestFocus();
                    return;
                }


                else  {
                    RegisterUser(txt_name,txt_email, txt_password);
                }
            }

            private void RegisterUser(String name, String email,  String password) {

                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                 Userlog user=new Userlog(name,email,password);
                                // user us=new user(email,password);

                                // FirebaseDatabase.getInstance().getReference("users")
                                    //     .child(email)


                                    reference.child(FirebaseAuth.getInstance().getCurrentUser().getUid())  .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                             @Override
                                             public void onComplete(@NonNull Task<Void> task) {
                                                 if (task.isSuccessful()) {
                                                     Toast.makeText(MainActivity.this, "register successfull", Toast.LENGTH_SHORT).show();
                                                     Intent intent=new Intent(MainActivity.this,login.class);
                                                     startActivity(intent);

                                                 }

                                             }
                                         });


                                } else {
                                    Toast.makeText(MainActivity.this, "register Failed", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

    }


}
