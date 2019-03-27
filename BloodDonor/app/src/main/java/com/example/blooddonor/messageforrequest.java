package com.example.blooddonor;

import android.Manifest;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.app.PendingIntent;
import android.content.Intent;
import android.telephony.SmsManager;
import android.widget.Toast;

public class messageforrequest extends AppCompatActivity {
    private EditText mb, me;
    ImageButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messageforrequest);
        mb = (EditText) findViewById(R.id.mobile);
        me = (EditText) findViewById(R.id.message);
        btn = (ImageButton) findViewById(R.id.imageButton);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String phoneNo = mb.getText().toString();
                String message = me.getText().toString();

//                try {
//                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                    sendIntent.putExtra("sms_body", "default content");
//                    sendIntent.setType("vnd.android-dir/mms-sms");
//                    startActivity(sendIntent);
//                } catch (Exception e) {
//                    Toast.makeText(getApplicationContext(), "SMS NOT Sent!", Toast.LENGTH_LONcG).show();
//                    e.printStackTrace();
//                }
                SmsManager sms=SmsManager.getDefault();

                Intent intent=new Intent(getApplicationContext(),messageforrequest.class);
                PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);

                sms.sendTextMessage(phoneNo, null, message, pi,null);
            }

        });
    }
}
