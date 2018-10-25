package com.example.guru.google;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Civil_faculty extends AppCompatActivity {

    private static String url = "http://rmkec.ac.in/mobileapp/civil_faculty.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Civil Faculty");
        new ProfileAsyncTask(this,getApplicationContext(),Civil_faculty.this,url).execute();
        // new Computer_center_faculty.callmethod().execute();
        setContentView(R.layout.activity_civil_faculty);


    }
}
