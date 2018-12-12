package com.example.lenovo.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnhome,btnmatkul,btntugas,btnquiz,btnlogout;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharePrefManager sharePrefManager = new SharePrefManager(MainActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnhome=findViewById(R.id.button);
        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,akun.class);
                startActivity(intent);

            }
        });

        btnmatkul=findViewById(R.id.button1);
        btnmatkul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,matkul.class);
                startActivity(intent);
            }
        });

        btntugas=findViewById(R.id.button2);
        btntugas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,tugas.class);
                startActivity(intent);
            }
        });

        btnquiz=findViewById(R.id.button3);
        btnquiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,quiz.class);
                startActivity(intent);
            }
        });

        btnlogout=findViewById(R.id.button4);
        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharePrefManager.saveSPBoolean(SharePrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, login.class));
                finish();
            }
        });
    }
}
