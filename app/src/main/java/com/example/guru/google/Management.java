package com.example.guru.google;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Management extends AppCompatActivity {
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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        setContentView(R.layout.activity_management);
        ImageView management=(ImageView) findViewById(R.id.management) ;
        TextView tv=(TextView)findViewById(R.id.chair_person_content);
        tv.setText(Html.fromHtml(getString(R.string.chairperson)));
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/mgt.jpg")
                .into(management);
        ImageView chairperson=(ImageView) findViewById(R.id.chair_person) ;

        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/MGT/management_04.jpg")
                .into(chairperson);
        TextView tv1=(TextView)findViewById(R.id.director_content);
        tv1.setText(Html.fromHtml(getString(R.string.director)));
        ImageView Director=(ImageView) findViewById(R.id.director) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/MGT/management_06.jpg")
                .into(Director);
        TextView tv2=(TextView)findViewById(R.id.vice_chair_content);
        tv2.setText(Html.fromHtml(getString(R.string.vice_chair)));
        ImageView vice_chair=(ImageView) findViewById(R.id.vice_chair) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/vc.jpg")
                .into(vice_chair);
        TextView tv3=(TextView)findViewById(R.id.secretary_content);
        tv3.setText(Html.fromHtml(getString(R.string.secretary)));
        ImageView secretary=(ImageView) findViewById(R.id.secretary) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/MGT/management_03.jpg")
                .into(secretary);
        TextView tv4=(TextView)findViewById(R.id.vice_chairperson_content);
        tv4.setText(Html.fromHtml(getString(R.string.vice_chairperson)));
        ImageView vice_chair_person=(ImageView) findViewById(R.id.vice_chairperson) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/MGT/management_07.jpg")
                .into(vice_chair_person);
        TextView tv5=(TextView)findViewById(R.id.trustee_content);
        tv5.setText(Html.fromHtml(getString(R.string.trustee)));
        ImageView trustee=(ImageView) findViewById(R.id.trustee) ;
        Picasso.with(this)
                .load("http://rmkec.ac.in/abt/img/vc_mam.jpg")
                .into(trustee);

    }
}
