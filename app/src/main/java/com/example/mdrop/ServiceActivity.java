package com.example.mdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ServiceActivity extends AppCompatActivity {
    Button btn_requestShelf, btn_dropOffOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        btn_dropOffOrder=findViewById(R.id.btn_dropOffOrder);
        btn_requestShelf=findViewById(R.id.btn_requestShelf);

        btn_requestShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ServiceActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}