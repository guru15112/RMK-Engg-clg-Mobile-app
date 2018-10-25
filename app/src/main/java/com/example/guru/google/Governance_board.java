package com.example.guru.google;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
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

public class Governance_board extends AppCompatActivity {
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
        setContentView(R.layout.activity_governance_board);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        new callmethod().execute();

    }
    private ProgressDialog pDialog;
    private static String url = "http://rmkec.ac.in/mobileapp/sys_governence.json";
    private class callmethod extends AsyncTask<Void, Void, Void> {
        private String TAG = News.class.getSimpleName();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Governance_board.this);
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


                                    ImageView governance_board=(ImageView) findViewById(R.id.governance_board) ;
                                    Picasso.with(Governance_board.this)
                                            .load(k.getString("cover_pic"))
                                            .into(governance_board);
                                    TextView board_address= (TextView) findViewById(R.id.board_address);
                                    board_address.setText(Html.fromHtml(k.getString("address_line")));

                                    TextView name_1= (TextView) findViewById(R.id.name_1);
                                    name_1.setText(Html.fromHtml(k.getString("FIELD22")));
                                    TextView name_2= (TextView) findViewById(R.id.name_2);
                                    name_2.setText(Html.fromHtml(k.getString("FIELD32")));
                                    TextView name_3= (TextView) findViewById(R.id.name_3);
                                    name_3.setText(Html.fromHtml(k.getString("FIELD42")));
                                    TextView name_4= (TextView) findViewById(R.id.name_4);
                                    name_4.setText(Html.fromHtml(k.getString("FIELD52")));
                                    TextView name_5= (TextView) findViewById(R.id.name_5);
                                    name_5.setText(Html.fromHtml(k.getString("FIELD62")));
                                    TextView name_6= (TextView) findViewById(R.id.name_6);
                                    name_6.setText(Html.fromHtml(k.getString("FIELD72")));
                                    TextView name_7= (TextView) findViewById(R.id.name_7);
                                    name_7.setText(Html.fromHtml(k.getString("FIELD82")));
                                    TextView name_8= (TextView) findViewById(R.id.name_8);
                                    name_8.setText(Html.fromHtml(k.getString("FIELD92")));
                                    TextView name_9= (TextView) findViewById(R.id.name_9);
                                    name_9.setText(Html.fromHtml(k.getString("FIELD102")));
                                    TextView name_10= (TextView) findViewById(R.id.name_10);
                                    name_10.setText(Html.fromHtml(k.getString("FIELD112")));
                                    TextView name_11= (TextView) findViewById(R.id.name_11);
                                    name_11.setText(Html.fromHtml(k.getString("FIELD122")));
                                    TextView name_12= (TextView) findViewById(R.id.name_12);
                                    name_12.setText(Html.fromHtml(k.getString("FIELD132")));
                                    TextView name_13= (TextView) findViewById(R.id.name_13);
                                    name_13.setText(Html.fromHtml(k.getString("FIELD142")));
                                    TextView name_14= (TextView) findViewById(R.id.name_14);
                                    name_14.setText(Html.fromHtml(k.getString("FIELD152")));
                                    TextView name_15= (TextView) findViewById(R.id.name_15);
                                    name_15.setText(Html.fromHtml(k.getString("FIELD162")));
                                    TextView name_16= (TextView) findViewById(R.id.name_16);
                                    name_16.setText(Html.fromHtml(k.getString("FIELD172")));
                                    TextView name_17= (TextView) findViewById(R.id.name_17);
                                    name_17.setText(Html.fromHtml(k.getString("FIELD182")));
                                    TextView name_18= (TextView) findViewById(R.id.name_18);
                                    name_18.setText(Html.fromHtml(k.getString("FIELD192")));
                                    TextView name_19= (TextView) findViewById(R.id.name_19);
                                    name_19.setText(Html.fromHtml(k.getString("FIELD102")));
                                    TextView name_20= (TextView) findViewById(R.id.name_20);
                                    name_20.setText(Html.fromHtml(k.getString("FIELD212")));
                                    TextView name_21= (TextView) findViewById(R.id.name_21);
                                    name_21.setText(Html.fromHtml(k.getString("FIELD222")));
                                    TextView name_22= (TextView) findViewById(R.id.name_22);
                                    name_22.setText(Html.fromHtml(k.getString("FIELD232")));

                                    TextView position_1= (TextView) findViewById(R.id.position_1);
                                    position_1.setText(Html.fromHtml(k.getString("FIELD23")));
                                    TextView position_2= (TextView) findViewById(R.id.position_2);
                                    position_2.setText(Html.fromHtml(k.getString("FIELD23")));
                                    TextView position_3= (TextView) findViewById(R.id.position_3);
                                    position_3.setText(Html.fromHtml(k.getString("FIELD43")));
                                    TextView position_4= (TextView) findViewById(R.id.position_4);
                                    position_4.setText(Html.fromHtml(k.getString("FIELD53")));
                                    TextView position_5= (TextView) findViewById(R.id.position_5);
                                    position_5.setText(Html.fromHtml(k.getString("FIELD63")));
                                    TextView position_6= (TextView) findViewById(R.id.position_6);
                                    position_6.setText(Html.fromHtml(k.getString("FIELD73")));
                                    TextView position_7= (TextView) findViewById(R.id.position_7);
                                    position_7.setText(Html.fromHtml(k.getString("FIELD83")));
                                    TextView position_8= (TextView) findViewById(R.id.position_8);
                                    position_8.setText(Html.fromHtml(k.getString("FIELD93")));
                                    TextView position_9= (TextView) findViewById(R.id.position_9);
                                    position_9.setText(Html.fromHtml(k.getString("FIELD103")));
                                    TextView position_10= (TextView) findViewById(R.id.position_10);
                                    position_10.setText(Html.fromHtml(k.getString("FIELD113")));
                                    TextView position_11= (TextView) findViewById(R.id.position_11);
                                    position_11.setText(Html.fromHtml(k.getString("FIELD123")));
                                    TextView position_12= (TextView) findViewById(R.id.position_12);
                                    position_12.setText(Html.fromHtml(k.getString("FIELD133")));
                                    TextView position_13= (TextView) findViewById(R.id.position_13);
                                    position_13.setText(Html.fromHtml(k.getString("FIELD143")));
                                    TextView position_14= (TextView) findViewById(R.id.position_14);
                                    position_14.setText(Html.fromHtml(k.getString("FIELD153")));
                                    TextView position_15= (TextView) findViewById(R.id.position_15);
                                    position_15.setText(Html.fromHtml(k.getString("FIELD163")));
                                    TextView position_16= (TextView) findViewById(R.id.position_16);
                                    position_16.setText(Html.fromHtml(k.getString("FIELD173")));
                                    TextView position_17= (TextView) findViewById(R.id.position_17);
                                    position_17.setText(Html.fromHtml(k.getString("FIELD183")));
                                    TextView position_18= (TextView) findViewById(R.id.position_18);
                                    position_18.setText(Html.fromHtml(k.getString("FIELD193")));
                                    TextView position_19= (TextView) findViewById(R.id.position_19);
                                    position_19.setText(Html.fromHtml(k.getString("FIELD203")));
                                    TextView position_20= (TextView) findViewById(R.id.position_20);
                                    name_20.setText(Html.fromHtml(k.getString("FIELD213")));
                                    TextView position_21= (TextView) findViewById(R.id.position_21);
                                    position_21.setText(Html.fromHtml(k.getString("FIELD223")));
                                    TextView position_22= (TextView) findViewById(R.id.position_22);
                                    position_22.setText(Html.fromHtml(k.getString("FIELD233")));

                                    TextView qualification_1= (TextView) findViewById(R.id.qualification_1);
                                    qualification_1.setText(Html.fromHtml(k.getString("FIELD24")));
                                    TextView qualification_2= (TextView) findViewById(R.id.qualification_2);
                                    qualification_2.setText(Html.fromHtml(k.getString("FIELD34")));
                                    TextView qualification_3= (TextView) findViewById(R.id.qualification_3);
                                    qualification_3.setText(Html.fromHtml(k.getString("FIELD44")));
                                    TextView qualification_4= (TextView) findViewById(R.id.qualification_4);
                                    qualification_4.setText(Html.fromHtml(k.getString("FIELD54")));
                                    TextView qualification_5= (TextView) findViewById(R.id.qualification_5);
                                    qualification_5.setText(Html.fromHtml(k.getString("FIELD64")));
                                    TextView qualification_6= (TextView) findViewById(R.id.qualification_6);
                                    qualification_6.setText(Html.fromHtml(k.getString("FIELD74")));
                                    TextView qualification_7= (TextView) findViewById(R.id.qualification_7);
                                    qualification_7.setText(Html.fromHtml(k.getString("FIELD84")));
                                    TextView qualification_8= (TextView) findViewById(R.id.qualification_8);
                                    qualification_8.setText(Html.fromHtml(k.getString("FIELD94")));
                                    TextView qualification_9= (TextView) findViewById(R.id.qualification_9);
                                    qualification_9.setText(Html.fromHtml(k.getString("FIELD104")));
                                    TextView qualification_10= (TextView) findViewById(R.id.qualification_10);
                                    qualification_10.setText(Html.fromHtml(k.getString("FIELD114")));
                                    TextView qualification_11= (TextView) findViewById(R.id.qualification_11);
                                    qualification_11.setText(Html.fromHtml(k.getString("FIELD124")));
                                    TextView qualification_12= (TextView) findViewById(R.id.qualification_12);
                                    qualification_12.setText(Html.fromHtml(k.getString("FIELD134")));
                                    TextView qualification_13= (TextView) findViewById(R.id.qualification_13);
                                    qualification_13.setText(Html.fromHtml(k.getString("FIELD144")));
                                    TextView qualification_14= (TextView) findViewById(R.id.qualification_14);
                                    qualification_14.setText(Html.fromHtml(k.getString("FIELD154")));
                                    TextView qualification_15= (TextView) findViewById(R.id.qualification_15);
                                    qualification_15.setText(Html.fromHtml(k.getString("FIELD164")));
                                    TextView qualification_16= (TextView) findViewById(R.id.qualification_16);
                                    qualification_16.setText(Html.fromHtml(k.getString("FIELD174")));
                                    TextView qualification_17= (TextView) findViewById(R.id.qualification_17);
                                    qualification_17.setText(Html.fromHtml(k.getString("FIELD184")));
                                    TextView qualification_18= (TextView) findViewById(R.id.qualification_18);
                                    qualification_18.setText(Html.fromHtml(k.getString("FIELD194")));
                                    TextView qualification_19= (TextView) findViewById(R.id.qualification_19);
                                    qualification_19.setText(Html.fromHtml(k.getString("FIELD204")));
                                    TextView qualification_20= (TextView) findViewById(R.id.qualification_20);
                                    qualification_20.setText(Html.fromHtml(k.getString("FIELD214")));
                                    TextView qualification_21= (TextView) findViewById(R.id.qualification_21);
                                    qualification_21.setText(Html.fromHtml(k.getString("FIELD224")));
                                    TextView qualification_22= (TextView) findViewById(R.id.qualification_22);
                                    qualification_22.setText(Html.fromHtml(k.getString("FIELD234")));


                                    TextView occupation_1= (TextView) findViewById(R.id.occupation_1);
                                    occupation_1.setText(Html.fromHtml(k.getString("FIELD25")));
                                    TextView occupation_2= (TextView) findViewById(R.id.occupation_2);
                                    occupation_2.setText(Html.fromHtml(k.getString("FIELD35")));
                                    TextView occupation_3= (TextView) findViewById(R.id.occupation_3);
                                    occupation_3.setText(Html.fromHtml(k.getString("FIELD45")));
                                    TextView occupation_4= (TextView) findViewById(R.id.occupation_4);
                                    occupation_4.setText(Html.fromHtml(k.getString("FIELD55")));
                                    TextView occupation_5= (TextView) findViewById(R.id.occupation_5);
                                    occupation_5.setText(Html.fromHtml(k.getString("FIELD65")));
                                    TextView occupation_6= (TextView) findViewById(R.id.occupation_6);
                                    occupation_6.setText(Html.fromHtml(k.getString("FIELD75")));
                                    TextView occupation_7= (TextView) findViewById(R.id.occupation_7);
                                    occupation_7.setText(Html.fromHtml(k.getString("FIELD85")));
                                    TextView occupation_8= (TextView) findViewById(R.id.occupation_8);
                                    occupation_8.setText(Html.fromHtml(k.getString("FIELD95")));
                                    TextView occupation_9= (TextView) findViewById(R.id.occupation_9);
                                    occupation_9.setText(Html.fromHtml(k.getString("FIELD105")));
                                    TextView occupation_10= (TextView) findViewById(R.id.occupation_10);
                                    occupation_10.setText(Html.fromHtml(k.getString("FIELD115")));
                                    TextView occupation_11= (TextView) findViewById(R.id.occupation_11);
                                    occupation_11.setText(Html.fromHtml(k.getString("FIELD125")));
                                    TextView occupation_12= (TextView) findViewById(R.id.occupation_12);
                                    occupation_12.setText(Html.fromHtml(k.getString("FIELD135")));
                                    TextView occupation_13= (TextView) findViewById(R.id.occupation_13);
                                    occupation_13.setText(Html.fromHtml(k.getString("FIELD145")));
                                    TextView occupation_14= (TextView) findViewById(R.id.occupation_14);
                                    occupation_14.setText(Html.fromHtml(k.getString("FIELD155")));
                                    TextView occupation_15= (TextView) findViewById(R.id.occupation_15);
                                    occupation_15.setText(Html.fromHtml(k.getString("FIELD165")));
                                    TextView occupation_16= (TextView) findViewById(R.id.occupation_16);
                                    occupation_16.setText(Html.fromHtml(k.getString("FIELD175")));
                                    TextView occupation_17= (TextView) findViewById(R.id.occupation_17);
                                    occupation_17.setText(Html.fromHtml(k.getString("FIELD185")));
                                    TextView occupation_18= (TextView) findViewById(R.id.occupation_18);
                                    occupation_18.setText(Html.fromHtml(k.getString("FIELD195")));
                                    TextView occupation_19= (TextView) findViewById(R.id.occupation_19);
                                    occupation_19.setText(Html.fromHtml(k.getString("FIELD205")));
                                    TextView occupation_20= (TextView) findViewById(R.id.occupation_20);
                                    occupation_20.setText(Html.fromHtml(k.getString("FIELD215")));
                                    TextView occupation_21= (TextView) findViewById(R.id.occupation_21);
                                    occupation_21.setText(Html.fromHtml(k.getString("FIELD225")));
                                    TextView occupation_22= (TextView) findViewById(R.id.occupation_22);
                                    occupation_22.setText(Html.fromHtml(k.getString("FIELD235")));



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
