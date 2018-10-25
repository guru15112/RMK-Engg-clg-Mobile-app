package com.example.guru.google;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Administration_procedure extends AppCompatActivity {
    private ProgressDialog pDialog;
    private static String url = "http://rmkec.ac.in/mobileapp/admission_procedure.json";
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=Menuhandling.processmenu(item,getApplicationContext());
        Log.d("star",intent.toString());
        if(!((intent.toString()).equals("Intent {  }")))
            startActivity(intent);
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration_procedure);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        new callmethod().execute();
    }
    private class callmethod extends AsyncTask<Void, Void, Void> {
        private String TAG = News.class.getSimpleName();
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(Administration_procedure.this);
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
                                    TextView intake_1 = (TextView) findViewById(R.id.intake_1);
                                    intake_1.setText(k.getString("be_course1_no"));
                                    TextView intake_2 = (TextView) findViewById(R.id.intake_2);
                                    intake_2.setText(k.getString("be_course2_no"));
                                    TextView intake_3 = (TextView) findViewById(R.id.intake_3);
                                    intake_3.setText(k.getString("be_course3_no"));
                                    TextView intake_4 = (TextView) findViewById(R.id.intake_4);
                                    intake_4.setText(k.getString("be_course4_no"));
                                    TextView intake_5 = (TextView) findViewById(R.id.intake_5);
                                    intake_5.setText(k.getString("be_course5_no"));

                                    TextView intake_6 = (TextView) findViewById(R.id.intake_6);
                                    intake_6.setText(k.getString("be_course6_no"));
                                    TextView intake_7 = (TextView) findViewById(R.id.intake_7);
                                    intake_7.setText(k.getString("btech_course_no"));
                                    TextView intake_8 = (TextView) findViewById(R.id.intake_8);
                                    intake_8.setText(k.getString("pg_course1_no"));
                                    TextView intake_9 = (TextView) findViewById(R.id.intake_9);
                                    intake_9.setText(k.getString("pg_course2_no"));
                                    TextView intake_10 = (TextView) findViewById(R.id.intake_10);
                                    intake_10.setText(k.getString("pg_course3_no"));
                                    TextView approved_course_1 = (TextView) findViewById(R.id.approved_course_1);
                                    approved_course_1.setText(k.getString("ms_phd_course1"));
                                    TextView approved_course_2 = (TextView) findViewById(R.id.approved_course_2);
                                    approved_course_2.setText(k.getString("ms_phd_course2"));
                                    TextView approved_course_3 = (TextView) findViewById(R.id.approved_course_3);
                                    approved_course_3.setText(k.getString("ms_phd_course3"));
                                    TextView approved_course_4 = (TextView) findViewById(R.id.approved_course_4);
                                    approved_course_4.setText(k.getString("ms_phd_course4"));
                                    TextView approved_course_5= (TextView) findViewById(R.id.approved_course_5);
                                    approved_course_5.setText(k.getString("ms_phd_course5"));
                                    TextView approved_course_6 = (TextView) findViewById(R.id.approved_course_6);
                                    approved_course_6.setText(k.getString("ms_phd_course6"));
                                    TextView eligibility_1 = (TextView) findViewById(R.id.eligibility_1);
                                    eligibility_1.setText(k.getString("eligiblity_para1"));
                                    TextView eligibility_2 = (TextView) findViewById(R.id.eligibility_2);
                                    eligibility_2.setText(k.getString("eligiblity_para2"));
                                    TextView eligibility_3 = (TextView) findViewById(R.id.eligibility_3);
                                    eligibility_3.setText(k.getString("eligiblity_para3"));
                                    TextView eligibility_4 = (TextView) findViewById(R.id.eligibility_4);
                                    eligibility_4.setText(k.getString("eligiblity_para4"));
                                    TextView general_condition_1 = (TextView) findViewById(R.id.general_condition_1);
                                    general_condition_1.setText(k.getString("general_condi1"));
                                    TextView general_condition_2 = (TextView) findViewById(R.id.general_condition_2);
                                    general_condition_2.setText(k.getString("general_condi2"));
                                    TextView general_condition_3 = (TextView) findViewById(R.id.general_condition_3);
                                    general_condition_3.setText(k.getString("general_condi3"));
                                    TextView general_condition_4 = (TextView) findViewById(R.id.general_condition_4);
                                    general_condition_4.setText(k.getString("general_condi4"));
                                    TextView s_no_2 = (TextView) findViewById(R.id.s_no_2);
                                    s_no_2.setText(Html.fromHtml(k.getString("eli_tab_r1_c1")));
                                    TextView s_no_3 = (TextView) findViewById(R.id.s_no_3);
                                    s_no_3.setText(Html.fromHtml(k.getString("eli_tab_r2_c1")));
                                    TextView s_no_4 = (TextView) findViewById(R.id.s_no_4);
                                    s_no_4.setText(Html.fromHtml(k.getString("eli_tab_r3_c1")));
                                    TextView sc_st_2 = (TextView) findViewById(R.id.sc_st_2);
                                    sc_st_2.setText(k.getString("eli_tab_r1_c2"));
                                    TextView sc_st_3 = (TextView) findViewById(R.id.sc_st_3);
                                    sc_st_3.setText(k.getString("eli_tab_r2_c2"));
                                    TextView sc_st_4 = (TextView) findViewById(R.id.sc_st_4);
                                    sc_st_4.setText(k.getString("eli_tab_r3_c2"));
                                    TextView mbc_mnc_2 = (TextView) findViewById(R.id.mbc_mnc_2);
                                    mbc_mnc_2.setText(k.getString("eli_tab_r1_c3"));
                                    TextView mbc_mnc_3 = (TextView) findViewById(R.id.mbc_mnc_3);
                                    mbc_mnc_3.setText(k.getString("eli_tab_r2_c3"));
                                    TextView mbc_mnc_4 = (TextView) findViewById(R.id.mbc_mnc_4);
                                    mbc_mnc_4.setText(k.getString("eli_tab_r3_c3"));
                                    TextView bc_2 = (TextView) findViewById(R.id.bc_2);
                                    bc_2.setText(k.getString("eli_tab_r1_c4"));
                                    TextView bc_3 = (TextView) findViewById(R.id.bc_3);
                                    bc_3.setText(k.getString("eli_tab_r2_c4"));
                                    TextView bc_4 = (TextView) findViewById(R.id.bc_4);
                                    bc_4.setText(k.getString("eli_tab_r3_c4"));
                                    TextView oc_2 = (TextView) findViewById(R.id.oc_2);
                                    oc_2.setText(k.getString("eli_tab_r1_c5"));
                                    TextView oc_3 = (TextView) findViewById(R.id.oc_3);
                                    oc_3.setText(k.getString("eli_tab_r2_c5"));
                                    TextView oc_4 = (TextView) findViewById(R.id.oc_4);
                                    oc_4.setText(k.getString("eli_tab_r3_c5"));


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
