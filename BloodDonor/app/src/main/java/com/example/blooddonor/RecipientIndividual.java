package com.example.blooddonor;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class RecipientIndividual extends AppCompatActivity {

    private TextView mTextMessage;
    private ProgressDialog loadingBar;
//    Intent intent;
//    Intent intent1;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_search:
//                    mTextMessage.setText(R.string.title_home);
                    Intent intent1 = new Intent(getApplicationContext(),messageforrequest.class);
                    startActivity(intent1);
                    break;


                case R.id.navigation_post:
//                    mTextMessage.setText(R.string.title_dashboard);
                    fragment = new postblood();
                    break;
                case R.id.navigation_logout:
                    loadingBar.setTitle("Logout Account");
                    loadingBar.setMessage("Please wait, while we are saving the details.");
                    loadingBar.setCanceledOnTouchOutside(false);
                    loadingBar.show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,fragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient_individual);

        mTextMessage = (TextView) findViewById(R.id.message);
        loadingBar = new ProgressDialog(this);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onBackPressed() {
    }

}
