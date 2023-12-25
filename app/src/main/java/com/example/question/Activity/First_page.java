package com.example.question.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.question.databinding.ActivityFirstPageBinding;

public class First_page extends AppCompatActivity {
    ActivityFirstPageBinding pageBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageBinding = ActivityFirstPageBinding.inflate(getLayoutInflater());
        setContentView(pageBinding.getRoot());
        getSupportActionBar().hide();
        pageBinding.creatAcount.setOnClickListener(v -> {
            startActivity(new Intent(First_page.this, CreatAcount.class));
            finish();
        });
        pageBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(First_page.this,LogingPage.class));
                finish();
            }
        });
    }
}