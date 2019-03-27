package com.example.blooddonor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DonorLogin extends AppCompatActivity {
    private EditText InputPhoneNumber, InputPassword;
    private Button LoginButton;
    private String parentDbName = "message";
    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor_login);
        LoginButton = (Button) findViewById(R.id.sign_in_button);
        InputPassword = (EditText) findViewById(R.id.password);
        InputPhoneNumber = (EditText) findViewById(R.id.mobilenumber);
        loadingBar = new ProgressDialog(this);
        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });
    }
        private void LoginUser()
        {
            String phone = InputPhoneNumber.getText().toString();
            String password = InputPassword.getText().toString();

            if (TextUtils.isEmpty(phone))
            {
                Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
            }
            else if (TextUtils.isEmpty(password))
            {
                Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
            }
            else
            {
                loadingBar.setTitle("Login Account");
                loadingBar.setMessage("Please wait, while we are checking the credentials.");
                loadingBar.setCanceledOnTouchOutside(false);
                loadingBar.show();


                AllowAccessToAccount(phone, password);
            }
        }



        private void AllowAccessToAccount(final String phone, final String password)
        {


            final DatabaseReference RootRef,reference;
            RootRef = FirebaseDatabase.getInstance().getReference();
            reference =  FirebaseDatabase.getInstance().getReference();
            RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child(parentDbName).child(phone).exists()) {
                        message usersData = dataSnapshot.child(parentDbName).child(phone).getValue(message.class);
//                        System.out.print("hello"+usersData.toString());
//                        String A = usersData;
//
                        if (usersData.getmobile().equals(phone)) {
                            if (usersData.getpassword().equals(password)) {
                                if (parentDbName.equals("message")) {
                                    Toast.makeText(DonorLogin.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                    loadingBar.dismiss();
                                    reference.child(parentDbName).child(phone);
//                                    String age =
//
                                    Intent intent = new Intent(DonorLogin.this,Individual.class);
//                                        intent.putExtra("Mobile",phone);
                                        intent.putExtra("age",new String[]{usersData.getage(),
                                                usersData.getbg(),usersData.getloc(),usersData.getemail(),usersData.getmobile()});
//                                    intent.putExtra("bg",usersData.getbg());
//                                    intent.putExtra("loc",usersData.getloc());
//                                    intent.putExtra("email",usersData.getemail());

                                    startActivity(intent);
                                }
                            } else {
                                loadingBar.dismiss();
                                Toast.makeText(DonorLogin.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        Toast.makeText(DonorLogin.this, "Account with this " + phone + " number do not exists.", Toast.LENGTH_SHORT).show();
                        loadingBar.dismiss();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
    }
}
