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

public class RecipientLogin extends AppCompatActivity {
    private EditText Inputuid, InputPassword;
    private Button LoginButton;
    private String parentDbName = "message1";
    private ProgressDialog loadingBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_login);

        LoginButton = (Button) findViewById(R.id.sign_in_button);
        InputPassword = (EditText) findViewById(R.id.password);
        Inputuid = (EditText) findViewById(R.id.uid);
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
        String uid = Inputuid.getText().toString();
        String password = InputPassword.getText().toString();

        if (TextUtils.isEmpty(uid))
        {
            Toast.makeText(this, "Please write your UID...", Toast.LENGTH_SHORT).show();
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


            AllowAccessToAccount(uid, password);
        }
    }



    private void AllowAccessToAccount(final String uid, final String password)
    {


        final DatabaseReference RootRef;
        RootRef = FirebaseDatabase.getInstance().getReference();
        RootRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.child(parentDbName).child(uid).exists()) {
                    message1 usersData = dataSnapshot.child(parentDbName).child(uid).getValue(message1.class);
//                        System.out.print("hello"+usersData.toString());
//                        String A = usersData;
//
                    if (usersData.getUid().equals(uid)) {
                        if (usersData.getPassword().equals(password)) {
                            if (parentDbName.equals("message1")) {
                                Toast.makeText(RecipientLogin.this, "Welcome Admin, you are logged in Successfully...", Toast.LENGTH_SHORT).show();
                                loadingBar.dismiss();
//
                                Intent intent = new Intent(RecipientLogin.this,RecipientIndividual.class);

                                startActivity(intent);
                            }
                        } else {
                            loadingBar.dismiss();
                            Toast.makeText(RecipientLogin.this, "Password is incorrect.", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(RecipientLogin.this, "Account with this " + uid + " number do not exists.", Toast.LENGTH_SHORT).show();
                    loadingBar.dismiss();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}