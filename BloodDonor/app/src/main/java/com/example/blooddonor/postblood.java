package com.example.blooddonor;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class postblood extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    private String location1;
    private String bg1;
    private Button btnSubmit;
    private Spinner gender, loc, bg;
    private EditText inputname, hospital, mobilenumber;
    post me;
    private DatabaseReference database;
    private DatabaseReference reff;

    public postblood() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        private EditText inputname,hospital,mobilenumber;

//        final Spinner bg,loc;
        View v = inflater.inflate(R.layout.fragment_postblood, container, false);
        Button b = (Button) v.findViewById(R.id.button);
        inputname = (EditText) v.findViewById(R.id.name);
        hospital = (EditText) v.findViewById(R.id.hospital);
        mobilenumber = (EditText) v.findViewById(R.id.mobilenumber);
        loc = (Spinner) v.findViewById(R.id.spinner9);
        bg = (Spinner) v.findViewById(R.id.spinner8);
        btnSubmit = (Button) v.findViewById(R.id.button4);
        me = new post();
        database = FirebaseDatabase.getInstance().getReference();
        reff = database.child("post");
        loc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                selectedyear = parentView.getSelectedItemPosition();
                location1 = loc.getSelectedItem().toString();

                //your code here

            }

            public void onNothingSelected(AdapterView<?> parentView) {

                //return;
            }
        });
//
        bg.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                selectedyear = parentView.getSelectedItemPosition();
                bg1 = bg.getSelectedItem().toString();

                //your code here

            }

            public void onNothingSelected(AdapterView<?> parentView) {

                //return;
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(,"BATMAN", Toast.LENGTH_LONG).show();
                String name1 = inputname.getText().toString().trim();
//                String password = inputPassword.getText().toString().trim();
                String mob1 = mobilenumber.getText().toString().trim();
                String hosp = hospital.getText().toString().trim();
//                int mob = mobilenumber.getText().toString().trim();
//                               Log.d("ravikrishna", gen);
//                System.out.println(gen);
                Log.d("hello", loc.getSelectedItem().toString());
                String location1 = loc.getSelectedItem().toString();
                String bg1 = bg.getSelectedItem().toString();

                if (TextUtils.isEmpty(name1)) {
                    Toast.makeText(getActivity(), "Enter email address!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(mob1)) {
                    Toast.makeText(getActivity(), "Enter password!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(hosp)) {
                    Toast.makeText(getActivity(), "Enter mobile number!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (location1.equals("Location")) {
                    Toast.makeText(getActivity(), "select location", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (bg1.equals("Blood Group")) {
                    Toast.makeText(getActivity(), "select blood group", Toast.LENGTH_SHORT).show();
                    return;
                }
                me.setName(name1);
                System.out.println(me);
                me.setMobile(mob1);
                me.setHospital(hosp);
                me.setLoc(location1);
                me.setBg(bg1);
                reff.child(mob1).setValue(me);
                Toast.makeText(getActivity(), "Details Inserted Successfully", Toast.LENGTH_SHORT).show();
//                prevalent.currentOnlineUser = dataSnapshot.child(parentDbName).child(phone).getValue(message.class);
                inputname.setText("");
                mobilenumber.setText("");
                hospital.setText("");
                loc.setSelection(0);
                bg.setSelection(0);
//                startActivity(new Intent(getActivity(), DonorLogin.class));
//                Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.VISIBLE);
////
            }
        });
        return v;
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

