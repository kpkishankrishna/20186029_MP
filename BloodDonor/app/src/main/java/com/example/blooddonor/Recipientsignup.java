package com.example.blooddonor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Recipientsignup extends AppCompatActivity {
    private EditText uid1, inputEmail, inputPassword;
    private Button btnSignIn,btnSignUp;
    private DatabaseReference database;
    private DatabaseReference reff;
    message1 me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipientsignup);
        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        uid1= (EditText) findViewById(R.id.uid);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.Name);
        inputPassword = (EditText) findViewById(R.id.password);
        database = FirebaseDatabase.getInstance().getReference();
        reff  = database.child("message1");
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RecipientLogin.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"BATMAN", Toast.LENGTH_LONG).show();
                String uid = uid1.getText().toString().trim();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                me = new message1();
//                String mob1 = mobilenumber.getText().toString().trim();
//                String age1 = age.getText().toString().trim();
//                int mob = mobilenumber.getText().toString().trim();
//                String gen = gender1;//                Log.d("ravikrishna", gen);
//                System.out.println(gen);
//                Log.d(gender.getSelectedItem().toString()+"hello", location.getSelectedItem().toString());
//                String loc =location.getSelectedItem().toString();
//                String bg = bgrp.getSelectedItem().toString();
                if (TextUtils.isEmpty(uid)) {
                    Toast.makeText(getApplicationContext(), "Enter uid Number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                me.setUid(uid);
                me.setEmail(email);
                me.setPassword(password);
                System.out.println(me);
                reff.child(uid).setValue(me);
                startActivity(new Intent(getApplicationContext(), RecipientLogin.class));
//                Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.VISIBLE);
////
            }
        });
    }
}
