package com.example.guru.google;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class Computer_center_faculty extends AppCompatActivity {
    private static String url = "http://rmkec.ac.in/mobileapp/computer_center_faculty.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       new ProfileAsyncTask(this,getApplicationContext(),Computer_center_faculty.this,url).execute();
       // new Computer_center_faculty.callmethod().execute();
        setContentView(R.layout.activity_computer_center_faculty);


    }
}