package com.example.mdrop;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView forgot_password;
    Button signIn_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        forgot_password=findViewById(R.id.forgot_password);
        signIn_button=findViewById(R.id.signIn_button);

        forgot_password.setOnClickListener(view -> {
            Intent intent=new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        signIn_button.setOnClickListener(view -> {
            Intent intent=new Intent(LoginActivity.this, ProfileActivity.class);
            startActivity(intent);
        });
    }
}