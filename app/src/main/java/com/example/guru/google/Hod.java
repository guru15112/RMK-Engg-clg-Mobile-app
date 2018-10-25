package com.example.guru.google;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Hod extends AppCompatActivity {
    private static String url = "http://rmkec.ac.in/mobileapp/hod.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new ProfileAsyncTask(this,getApplicationContext(),Hod.this,url).execute();
        // new Computer_center_faculty.callmethod().execute();
        setContentView(R.layout.activity_hod);


    }
}