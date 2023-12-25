package com.example.question.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.question.databinding.ActivityLogingPageBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class LogingPage extends AppCompatActivity {
    ActivityLogingPageBinding logingPageBinding;
    FirebaseAuth auth;
    ProgressDialog dialog;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        logingPageBinding=ActivityLogingPageBinding.inflate(getLayoutInflater());
        setContentView(logingPageBinding.getRoot());
        getSupportActionBar().hide();
        logingPageBinding.forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogingPage.this,ResetPassword.class));
            }
        });
        logingPageBinding.imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LogingPage.this,First_page.class));
                finish();
            }
        });

        //To Start User email login
        auth = FirebaseAuth.getInstance();
        logingPageBinding.button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auth.signInWithEmailAndPassword(logingPageBinding.editTextTextPersonName.getText().toString(),
                        logingPageBinding.editTextTextPassword2.getText().toString()).
                        addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            startActivity(new Intent(LogingPage.this,ProfilePage.class));
                        }
                        else {
                            Toast.makeText(LogingPage.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });
        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(LogingPage.this,ProfilePage.class));
        }



    }
}
