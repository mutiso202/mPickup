package com.example.mdrop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Create_Account_Activity extends AppCompatActivity {
    Button signUp_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        signUp_button=findViewById(R.id.signUp_button);

        signUp_button.setOnClickListener(view -> {
            Intent intent=new Intent(Create_Account_Activity.this,ProfileActivity.class);
            startActivity(intent);
        });
    }
}