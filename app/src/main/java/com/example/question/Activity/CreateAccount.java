package com.example.question.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.question.databinding.ActivityCreateAccountBinding;
import com.example.question.modle.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class CreateAccount extends AppCompatActivity {
      ActivityCreateAccountBinding createAccountBinding;
      private FirebaseAuth auth;
      FirebaseDatabase database;
      ProgressDialog dialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        createAccountBinding = ActivityCreateAccountBinding.inflate(getLayoutInflater());
        setContentView(createAccountBinding.getRoot());
        getSupportActionBar().hide();


        createAccountBinding.textView19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CreateAccount.this,LogingPage.class);
                startActivity(intent);
            }
        });

        auth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

        dialog = new ProgressDialog(CreateAccount.this);
        dialog.setTitle("Creating Account");
        dialog.setMessage("we'r creating your account");

        createAccountBinding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                auth.createUserWithEmailAndPassword(createAccountBinding.editTextTextEmailAddress2.getText().toString(),
                        createAccountBinding.editTextTextPassword4.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        dialog.dismiss();

                        if (task.isSuccessful()){
                            Users users = new Users(createAccountBinding.editTextTextPersonName2.getText().toString(),
                                    createAccountBinding.editTextTextEmailAddress2.getText().toString(),
                                    createAccountBinding.editTextTextPassword4.getText().toString());
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(users);
                            Toast.makeText(CreateAccount.this, "User Creat Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Toast.makeText(CreateAccount.this,task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });

            }
        });

        createAccountBinding.imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccount.this, CreatAcount.class));
                finish();
            }
        });
    }
}