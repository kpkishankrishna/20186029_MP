package com.example.blooddonor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Donorsignup extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private EditText inputEmail, inputPassword,mobilenumber,age;   //hit option + enter if you on mac , for windows hit ctrl + enter
    private Button btnSignIn, btnSignUp, btnResetPassword;
    private ProgressBar progressBar;
    private TextView a;
    long maxid = 0;
//        private FirebaseAuth auth;
    private DatabaseReference database;
    private DatabaseReference reff;
    private Spinner gender,location,bgrp;
    private String gender1;
    private String location1;
    private String bg1;
    message me;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donorsignup);
        FirebaseApp.initializeApp(getApplicationContext());
        btnSignIn = (Button) findViewById(R.id.sign_in_button);
        btnSignUp = (Button) findViewById(R.id.sign_up_button);
        inputEmail = (EditText) findViewById(R.id.email);
        inputPassword = (EditText) findViewById(R.id.password);
        mobilenumber = (EditText) findViewById(R.id.mobilenumber);
        age = (EditText) findViewById(R.id.age);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        btnResetPassword = (Button) findViewById(R.id.btn_reset_password);
        gender = (Spinner) findViewById(R.id.spinner1);
        location = (Spinner) findViewById(R.id.spinner2);
        bgrp = (Spinner) findViewById(R.id.spinner3);
        me = new message();
        database = FirebaseDatabase.getInstance().getReference();
        reff  = database.child("message");
        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists())
                maxid = (dataSnapshot.getChildrenCount());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //
//        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);


//        gender.setOnItemSelectedListener(this);
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
//                selectedyear = parentView.getSelectedItemPosition();
                gender1 = gender.getSelectedItem().toString();

                //your code here

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

                //return;
            }
        });


        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
//                selectedyear = parentView.getSelectedItemPosition();
                location1 = gender.getSelectedItem().toString();

                //your code here

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

                //return;
            }
        });
//
        bgrp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id)
            {
//                selectedyear = parentView.getSelectedItemPosition();
                bg1 = gender.getSelectedItem().toString();

                //your code here

            }

            public void onNothingSelected(AdapterView<?> parentView)
            {

                //return;
            }
        });


//        btnResetPassword.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Donorsignup.this, Donorreset.class));
//            }
//        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Donorsignup.this, DonorLogin.class));
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"BATMAN", Toast.LENGTH_LONG).show();
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String mob1 = mobilenumber.getText().toString().trim();
                String age1 = age.getText().toString().trim();
//                int mob = mobilenumber.getText().toString().trim();
                String gen = gender1;//                Log.d("ravikrishna", gen);
//                System.out.println(gen);
                Log.d(gender.getSelectedItem().toString()+"hello", location.getSelectedItem().toString());
                String loc =location.getSelectedItem().toString();
                String bg = bgrp.getSelectedItem().toString();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mob1)) {
                    Toast.makeText(getApplicationContext(), "Enter mobile number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(mob1.length() < 10 || mob1.length() > 10) {
                    Toast.makeText(getApplicationContext(), "Enter mobile number with 10 digits", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (gen.equals("Gender")) {
                    Toast.makeText(getApplicationContext(), "Select gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (loc.equals("Location")) {
                    Toast.makeText(getApplicationContext(), "select location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (bg.equals("Blood Group")) {
                    Toast.makeText(getApplicationContext(), "select blood group", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                    return;
                }
                me.setemail(email);
                me.setpassword(password);
                System.out.println(me);
                me.setmobile(mob1);
                me.setage(age1);
                me.setgender(gen);
                me.setloc(loc);
                me.setbg(bg);
                reff.child(mob1).setValue(me);
                startActivity(new Intent(Donorsignup.this, DonorLogin.class));
//                Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.VISIBLE);
////
            }
        });
    }

    @Override
    protected void onResume () {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }


    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}