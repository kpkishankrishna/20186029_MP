package com.example.blooddonor;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Individual extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private TextView name,age,bg,loc,mobile;
    static String mobile1 = "",email = "",age1 = "",bg1 = "",loc1 = "";
    String[] a = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual);
Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        age = (TextView) findViewById(R.id.textView6);

      a = getIntent().getStringArrayExtra("age");

        Toast.makeText(Individual.this,mobile1,Toast.LENGTH_SHORT).show();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new bloodtips());
            ft.commit();
        navigationView.setCheckedItem(R.id.nav_tips);
    }


    @Override
    public void onBackPressed() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.individual, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent i= new Intent(getApplicationContext(),profile.class);
//            i.putExtra("Mobile",mobile1);
            i.putExtra("age",a);
//            i.putExtra("bg",a);
//            i.putExtra("email",email);
//            i.putExtra("loc",loc1);

            startActivity(i);
        } else if (id == R.id.nav_view_blood) {
            Intent i= new Intent(getApplicationContext(),seeblood.class);
            startActivity(i);
        } else if (id == R.id.nav_tips) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new bloodtips());
            ft.commit();

        } else if (id == R.id.nav_guide) {
            android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.flMain,new guidelines());
            ft.commit();


        }else if (id == R.id.nav_logout) {
            Intent i = new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_share) {
            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String shareBody = "Name" + ":" + a[3] + "" + "Mobile" + ":" + a[4] + "Blood Group" + ":" + a[1];
            ;
//            String shareSub = "Name"+":"+ a[3]+ ""+"Mobile"+":"+a[4] + "Blood Group"+":"+a[1];
//            i.putExtra(Intent.EXTRA_SUBJECT,shareSub);
            i.putExtra(Intent.EXTRA_TEXT, shareBody);
            startActivity(Intent.createChooser(i, "Share Using"));


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
