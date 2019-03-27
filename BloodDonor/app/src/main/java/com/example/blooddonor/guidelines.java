package com.example.blooddonor;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class guidelines extends Fragment {


    public guidelines() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_guidelines,container,false);
        Button b= (Button)v.findViewById(R.id.button);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(Donorsignup.this, DonorLogin.class));
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://indianbloodbank.com/donors-guidelines.html"));
               // intent.setData(Uri.parse("https://www.google.co.in/"));
                startActivity(intent);
            }
        });
        return v;
    }

}
