package com.example.guru.google;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import static com.example.guru.google.Dialogbox.settextdisplay;

public class Homescreen extends AppCompatActivity {

    public boolean onCreateOptionsMenu(Menu menu)
    {     Log.d("star","Hello"+"");
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=Menuhandling.processmenu(item,getApplicationContext());

        if(!((intent.toString()).equals("Intent {  }")))

            startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Home");
        setContentView(R.layout.activity_homescreen);
        ImageView management=(ImageView) findViewById(R.id.management);
        ImageView news=(ImageView) findViewById(R.id.news);
        ImageView contact_us=(ImageView) findViewById(R.id.contact_us);
        ImageView hod=(ImageView) findViewById(R.id.hod);
        management.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent=new Intent(Homescreen.this,Management.class);
        startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Homescreen.this,News.class);
        startActivity(intent);
            }
        });
        contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent=new Intent(Homescreen.this,Contactus.class);
        startActivity(intent);
            }
        });
       hod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  Intent intent=new Intent(Homescreen.this,Hod.class);
        startActivity(intent);
            }
        });
    }
}
