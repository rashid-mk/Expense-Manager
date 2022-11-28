package com.msqapps.expensemanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class addbook extends AppCompatActivity {
    private EditText name;
    private RadioButton person;
    private RadioButton group;
    private Button save;
    private Button cancel;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addbook);

    }

}