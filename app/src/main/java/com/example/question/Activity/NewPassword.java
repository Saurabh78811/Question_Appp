package com.example.question.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.question.databinding.ActivityNewPasswordBinding;

public class NewPassword extends AppCompatActivity {
    ActivityNewPasswordBinding newPasswordBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        newPasswordBinding=ActivityNewPasswordBinding.inflate(getLayoutInflater());
        setContentView(newPasswordBinding.getRoot());
        getSupportActionBar().hide();
    }
}