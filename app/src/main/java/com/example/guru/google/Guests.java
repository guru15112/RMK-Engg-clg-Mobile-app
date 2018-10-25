package com.example.guru.google;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class Guests extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home)
        {
            this.finish();
        }
        else
        {
            Intent intent=Menuhandling.processmenu(item,getApplicationContext());
            Log.d("star",intent.toString());

            if (!((intent.toString()).equals("Intent {  }")))
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guests);
        ImageView anil_kakodkar=(ImageView) findViewById(R.id.anil_kakodkar) ;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/ic_1.jpg")
                .into(anil_kakodkar);
        ImageView nandan_nilekani=(ImageView) findViewById(R.id.nandan_nilekani) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/ic_2.jpg")
                .into(nandan_nilekani);
        ImageView sudha_murthy=(ImageView) findViewById(R.id.sudha_murthy) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/ic_3.jpg")
                .into(sudha_murthy);
        ImageView ramadorai=(ImageView) findViewById(R.id.ramadorai) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/ic_4.jpg")
                .into(ramadorai);


    }
}
