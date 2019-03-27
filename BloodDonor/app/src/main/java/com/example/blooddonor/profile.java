package com.example.blooddonor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    private TextView a,b,c,d,e;
    static String mobile = "";
    String[] ab = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        a = (TextView) findViewById(R.id.name1);
        b = (TextView) findViewById(R.id.age1);
        c = (TextView) findViewById(R.id.bg1);
        d = (TextView) findViewById(R.id.locloc1);
        e = (TextView) findViewById(R.id.mobilenumber1);
//       e.setText(getIntent().getStringExtra("Mobile"));
//        a.setText(getIntent().getStringExtra("email"));
//        c.setText(getIntent().getStringExtra("bg"));
        ab =getIntent().getStringArrayExtra("age");
        b.setText(ab[0]);
        c.setText(ab[1]);
        d.setText(ab[2]);
        a.setText(ab[3]);
        e.setText(ab[4]);
//        d.setText(getIntent().getStringExtra("loc"));
//        mobile = e.getText().toString();

    }
}
