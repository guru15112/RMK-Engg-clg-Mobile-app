package com.example.guru.google;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

@RequiresApi(api = Build.VERSION_CODES.N)
public class Registration extends AppCompatActivity {

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Menuhandling.processmenu(item,getApplicationContext());
        return super.onOptionsItemSelected(item);
    }
    void postdata() {

        StringBuilder sb = new StringBuilder();

        String http = getString(R.string.ipadress)+"/putregistration.php";
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(http);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setDoOutput(true);
            urlConnection.setRequestMethod("POST");
            urlConnection.setUseCaches(false);
            urlConnection.setReadTimeout(10000);
            urlConnection.setConnectTimeout(15000);
            urlConnection.setRequestProperty("Content-Type", "application/json");
            Log.d("Main", "" + urlConnection);
            urlConnection.connect();


            JSONObject jsonParam = new JSONObject();
            Log.d("Main", "" + urlConnection);
            EditText enter_register_number=(EditText) findViewById(R.id.enterregisternumber);
            EditText enter_name=(EditText) findViewById(R.id.entername);
            EditText enter_email=(EditText) findViewById(R.id.enteremail);
            EditText enter_dob=(EditText) findViewById(R.id.enter_dob);
            EditText enter_mobileno=(EditText) findViewById(R.id.entermobilenumber);
            EditText enter_alt_email=(EditText) findViewById(R.id.enteraltemail);
            EditText enter_password=(EditText) findViewById(R.id.enterpassword);
            Spinner select_department=(Spinner) findViewById(R.id.selectdepartment);
            Spinner select_branch=(Spinner) findViewById(R.id.selectbatch);
            Spinner select_category=(Spinner) findViewById(R.id.selectcategry);
            jsonParam.put("regno", enter_register_number.getText().toString());
            jsonParam.put("name", enter_name.getText().toString());
            jsonParam.put("dob", enter_dob.getText().toString());
            jsonParam.put("dept", select_department.getSelectedItem().toString());
            jsonParam.put("batch", select_branch.getSelectedItem().toString());
            jsonParam.put("category", select_category.getSelectedItem().toString());
            jsonParam.put("mobileno", enter_mobileno.getText().toString());
            jsonParam.put("email", enter_email.getText().toString());
            jsonParam.put("altemail", enter_alt_email.getText().toString());
            jsonParam.put("password",enter_password.getText().toString());





            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(jsonParam.toString());
            Log.d("json_check", jsonParam.toString());
            Log.d("Check1", "post successful");
            out.close();

            int HttpResult = urlConnection.getResponseCode();
            if (HttpResult == HttpURLConnection.HTTP_OK) {
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream(), "utf-8"));
                String line;
                while (null != (line = br.readLine())) {
                    sb.append(line).append("\n");
                }
                br.close();

                System.out.println("" + sb.toString());

                final JSONObject respObject = new JSONObject(sb.toString());

                System.out.println(respObject.getString("a"));
                try {
                    runOnUiThread(new Runnable() {
                        public void run() {
                            try {

                                Toast.makeText(Registration.this,respObject.getString("a"), Toast.LENGTH_LONG).show();
                                if (respObject.getString("a").equals("success")) {
                                    Intent intent1=new Intent(Registration.this,News.class);

                                    startActivity(intent1);
                                    finish();

                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                } catch (Exception e) {
                    System.out.println("output error");
                    e.printStackTrace();
                }

            } else {
                System.out.println(urlConnection.getResponseMessage());
            }
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            System.out.println("Error here");
            runOnUiThread( new Runnable() {
                @Override
                public void run() {

                    Toast.makeText(Registration.this,"Network error",Toast.LENGTH_SHORT).show();
                }
            });
        } finally {
            if (urlConnection != null)
                urlConnection.disconnect();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        final Spinner department = (Spinner) findViewById(R.id.selectdepartment);
        ArrayAdapter<CharSequence> departmentadapter = ArrayAdapter.createFromResource(
                this, R.array.department, R.layout.spinner_layout);
        department.setAdapter(departmentadapter);
        final Spinner batch = (Spinner) findViewById(R.id.selectbatch);
        ArrayAdapter<CharSequence> batchadapter = ArrayAdapter.createFromResource(
                this, R.array.batch, R.layout.spinner_layout);
        batch.setAdapter(batchadapter);
        final Spinner category = (Spinner) findViewById(R.id.selectcategry);
        ArrayAdapter<CharSequence> categoryadapter = ArrayAdapter.createFromResource(
                this, R.array.category, R.layout.spinner_layout);
        category.setAdapter(categoryadapter);
        Bundle bundle=getIntent().getExtras();
        String email=bundle.getString("email");
        String fullname=bundle.getString("fullname");
        EditText enter_name=(EditText) findViewById(R.id.entername);
        EditText enter_email=(EditText) findViewById(R.id.enteremail);
        enter_email.setText(email);
        enter_email.setEnabled(false);
        final EditText enter_dob=(EditText) findViewById(R.id.enter_dob);
        enter_dob.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //To show current date in the datepicker
                Calendar mcurrentDate= Calendar.getInstance();
              int  mYear=mcurrentDate.get(Calendar.YEAR);
               int mMonth=mcurrentDate.get(Calendar.MONTH);
              int  mDay=mcurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker=new DatePickerDialog(Registration.this, new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        // TODO Auto-generated method stub
                        selectedmonth++;
                    /*      Your code   to get date and time    */
                    enter_dob.setText(selectedyear+"-"+selectedmonth+"-"+selectedday);
                    }
                },mYear, mMonth, mDay);
                mDatePicker.setTitle("Select date");
                mDatePicker.show();  }
        });
        enter_name.setText(fullname);
        Button register=(Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
                                   public void onClick(View v) {
                                        EditText enter_register_number=(EditText) findViewById(R.id.enterregisternumber);
                                       EditText enter_name=(EditText) findViewById(R.id.entername);
                                       EditText enter_email=(EditText) findViewById(R.id.enteremail);
                                       EditText enter_dob=(EditText) findViewById(R.id.enter_dob);
                                       EditText enter_mobileno=(EditText) findViewById(R.id.entermobilenumber);
                                       EditText enter_alt_email=(EditText) findViewById(R.id.enteraltemail);
                                       EditText enter_password=(EditText) findViewById(R.id.enterpassword);
                                       Spinner select_department=(Spinner) findViewById(R.id.selectdepartment);
                                       Spinner select_branch=(Spinner) findViewById(R.id.selectbatch);
                                       Spinner select_category=(Spinner) findViewById(R.id.selectcategry);

                                       String register_number=enter_register_number.getText().toString();
                                       String name=enter_name.getText().toString();
                                       String date_of_birth=enter_dob.getText().toString();
                                       String department=select_department.getSelectedItem().toString();
                                       String mobileno=enter_mobileno.getText().toString();
                                       String alt_email=enter_alt_email.getText().toString();
                                       String password=enter_password.getText().toString();
                                       String branch=select_branch.getSelectedItem().toString();
                                       String category=select_category.getSelectedItem().toString();
                                       String email=enter_email.getText().toString();
                                       if (enter_register_number.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Register Number", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else if (enter_name.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Fullname", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       }
                                       else if (enter_dob.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Your Date of Birth", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       }
                                       else if (select_department.getSelectedItem().toString().equals("Select")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Select Valid Department", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else if (enter_mobileno.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Mobile number", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else if (enter_alt_email.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Alternate email", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else if (enter_password.getText().toString().equals("")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Enter Password", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       }
                                     else if (select_branch.getSelectedItem().toString().equals("Select")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Select Valid Batch", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else if (select_category.getSelectedItem().toString().equals("Select")) {
                                           runOnUiThread(new Runnable() {
                                               @Override
                                               public void run() {

                                                   Toast.makeText(Registration.this, "Select Valid Category", Toast.LENGTH_SHORT).show();
                                               }
                                           });
                                       } else {

                                          /* new Thread(

                                                   new Runnable() {
                                                       @Override
                                                       public void run() {
                                                           postdata();
                                                       }
                                                   }).start();*/
                                           new SendPostRequest().execute(register_number,name,date_of_birth,department,mobileno,email,alt_email,password,branch,category);
                                       }
                                   }
                               }
        );
    }
    public class SendPostRequest extends AsyncTask<String, Void, String> {

        protected void onPreExecute(){}

        protected String doInBackground(String... arg) {
            try {

                URL url = new URL(getString(R.string.ipadress)+"/putregistration.php"); // here is your URL path

                JSONObject jsonParam = new JSONObject();

                jsonParam.put("regno", arg[0]);
                jsonParam.put("name", arg[1]);
                jsonParam.put("dob", arg[2]);
                jsonParam.put("dept", arg[3]);
                jsonParam.put("batch", arg[7]);
                jsonParam.put("category", arg[9]);
                jsonParam.put("mobileno", arg[4]);
                jsonParam.put("email", arg[5]);
                jsonParam.put("altemail", arg[6]);
                jsonParam.put("password",arg[8]);
               // postDataParams.put("name", "abc");
                //postDataParams.put("email", "abc@gmail.com");
                Log.e("params",jsonParam.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(jsonParam));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
        }
    }
    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }

}

