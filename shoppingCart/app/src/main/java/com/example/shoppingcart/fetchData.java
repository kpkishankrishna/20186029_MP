package com.example.shoppingcart;
import android.os.AsyncTask;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.google.android.gms.common.util.JsonUtils;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class fetchData extends AsyncTask<Void,Void, Void>{

    String line="";
    String data = "";
    private static final String TAG = "here is the error";
    JSONArray JA;
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://msitmp.herokuapp.com/getproducts/20186029");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream =   httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (line!=null){
                line = bufferedReader.readLine();
                data = data+line;
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            JSONObject JO = new JSONObject(data);
            JA = JO.getJSONArray("Product");
            final DatabaseReference Rootref;
            Rootref = FirebaseDatabase.getInstance().getReference();
            jsonUtils j = new jsonUtils();
            Map<String,Object> map = j.jsonToMap(JO);
            Rootref.setValue(map);
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return null;

    }
    @Override
    protected void onPostExecute(Void aVoid){
        super.onPostExecute(aVoid);

    }

}
