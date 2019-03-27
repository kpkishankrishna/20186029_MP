package com.example.blooddonor;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class seeblood extends AppCompatActivity {
    public ListView list;
    //    Firebase myfiredata;
    private DatabaseReference myfiredata;
    public ArrayList<userblood> arraylist = new ArrayList<>();
    public ArrayAdapter<userblood> adapter;
    public TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeblood);
        myfiredata = FirebaseDatabase.getInstance().getReference();
        adapter = new ArrayAdapter<userblood>(this, android.R.layout.simple_list_item_1, arraylist);
        list = (ListView) findViewById(R.id.listv);

        myfiredata.child("post").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> userdata = dataSnapshot.getChildren();
                for(DataSnapshot child : userdata){
                    userblood userinfo = child.getValue(userblood.class);
                    adapter.add(userinfo);

                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        list.setAdapter(adapter);
    }
}

