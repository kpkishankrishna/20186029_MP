package com.example.assignment_12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mToysListTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToysListTextView = (TextView) findViewById(R.id.tv_toy_names);
        String[] toyNames = com.example.android.favoritetoys.ToyBox.getToyNames();

        for (String toyName : toyNames) {
            mToysListTextView.append(toyName + "\n\n\n");
        }
    }
}