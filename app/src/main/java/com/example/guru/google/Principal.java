package com.example.guru.google;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Principal extends AppCompatActivity {
    private ProgressDialog pDialog;
    private static String url = "http://rmkec.ac.in/mobileapp/principal.json";
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
        new callmethod().execute();
        setContentView(R.layout.activity_principal);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


    }
    private class callmethod extends AsyncTask<Void, Void, Void> {
        private String TAG = News.class.getSimpleName();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Principal.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {
            Httphandler sh = new Httphandler();

            String jsonStr = sh.makeServiceCall(url);


            if (jsonStr != null) {
                try {
                    JSONArray contacts = new JSONArray(jsonStr);
                    final JSONObject k = contacts.getJSONObject(0);
                    try {
                        Log.e(TAG, "yuvaraj " + k);
                        runOnUiThread(new Runnable() {
                            public void run() {
                                try {
                                    TextView principal_1 = (TextView) findViewById(R.id.principal_1);
                                    TextView principal_2 = (TextView) findViewById(R.id.principal_2);
                                    TextView principal_3 = (TextView) findViewById(R.id.principal_3);
                                    TextView principal_4 = (TextView) findViewById(R.id.principal_4);
                                    ImageView principal=(ImageView) findViewById(R.id.principal) ;
                                    Picasso.with(Principal.this)
                                            .load(k.getString("imag_url"))
                                            .into(principal);
                                    principal_1.setText(k.getString("para1"));
                                    principal_2.setText(k.getString("para2"));
                                    principal_3.setText(k.getString("para3"));
                                    principal_4.setText(k.getString("para4"));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    } catch (Exception e) {
                        System.out.println("output error");
                    }
                }
                  catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG)
                                    .show();
                        }
                    });

                }

            }else {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }
            return null;
        }



        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();


        }
    }
}
