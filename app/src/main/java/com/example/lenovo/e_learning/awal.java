package com.example.lenovo.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class awal extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_awal);

        Intent intent=new Intent(awal.this,login.class);
        startActivity(intent);
    }
}
