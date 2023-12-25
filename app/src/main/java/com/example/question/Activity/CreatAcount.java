package com.example.question.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.question.databinding.ActivityCreatAcountBinding;

public class CreatAcount extends AppCompatActivity {
    ActivityCreatAcountBinding creatAcountBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        creatAcountBinding = ActivityCreatAcountBinding.inflate(getLayoutInflater());
        setContentView(creatAcountBinding.getRoot());
        getSupportActionBar().hide();
        creatAcountBinding.signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreatAcount.this, CreateAccount.class));
            }
        });
    }
}