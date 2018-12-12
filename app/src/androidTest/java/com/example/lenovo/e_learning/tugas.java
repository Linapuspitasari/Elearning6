package com.example.lenovo.e_learning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tugas extends AppCompatActivity {
    Button btndetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_tugas);

        btndetail=findViewById(R.id.button15);
        btndetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(tugas.this,detail_tugas.class);
                startActivity(intent);

            }
    });
}

}