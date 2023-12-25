package com.example.question.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.question.databinding.ActivityResetPasswordBinding;

public class ResetPassword extends AppCompatActivity {
    ActivityResetPasswordBinding resetPasswordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resetPasswordBinding = ActivityResetPasswordBinding.inflate(getLayoutInflater());
        setContentView(resetPasswordBinding.getRoot());
        getSupportActionBar().hide();
        resetPasswordBinding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResetPassword.this,LogingPage.class));
            }
        });
        resetPasswordBinding.restPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ResetPassword.this,NewPassword.class));
            }
        });
    }
}