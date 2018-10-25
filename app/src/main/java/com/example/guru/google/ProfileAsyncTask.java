package com.example.guru.google;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Handler;

import android.os.AsyncTask;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.guru.google.Dialogbox.setimagedisplay;
import static com.example.guru.google.Dialogbox.settextdisplay;

/**
 * Created by Guru venkatesh on 12/5/2017.
 */

public class ProfileAsyncTask extends AsyncTask<Void, Void, Void>  {
    private static String url ;
    private ProgressDialog pDialog;
    Context context;
    Context context_tag;
    Activity layout_activity;
    private String TAG = News.class.getSimpleName();
    private ListView lv;
    ArrayList<HashMap<String,String>> arrayList=new ArrayList<>();
    public ProfileAsyncTask(Context context1,Context context2,Activity activity,String url1){
        super();
        context=context1;
        context_tag=context2;
        layout_activity=activity;
        url=url1;
    }
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        pDialog = new ProgressDialog(context);
        pDialog.setMessage("Please wait...");
        pDialog.setCancelable(false);
//        pDialog.show();

    }

    @Override
    protected Void doInBackground(Void... arg0) {
        Httphandler sh = new Httphandler();

        final String jsonStr = sh.makeServiceCall(url);


        if (jsonStr != null) {
            try {
                JSONArray contacts = new JSONArray(jsonStr);
                final JSONObject k = contacts.getJSONObject(0);
                try {

                    Clientplayer.runOnUI(new Runnable() {
                        public void run() {
                            try {
                                Log.e(TAG, "food " + jsonStr);


                                // Getting JSON Array node
                                JSONArray contacts = new JSONArray(jsonStr);



                                // looping through All Contacts
                                for (int i = 0; i < contacts.length(); i++) {
                                    JSONObject c = contacts.getJSONObject(i);

                                    String name = Html.fromHtml(c.getString("name")).toString();
                                    String picture = c.getString("img_url");
                                    String link = c.getString("link");
                                    String profile = Html.fromHtml(c.getString("profile")).toString();
                                    HashMap<String,String> hashMap=new HashMap<>();//create a hashmap to store the data in key value pair
                                    hashMap.put("name",name);
                                    hashMap.put("picture",picture);
                                    hashMap.put("profile",profile);
                                    hashMap.put("link",link);
                                    arrayList.add(hashMap);
                                }

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
                Clientplayer.runOnUI(new Runnable() {
                    public void run() {
                        Toast.makeText(context_tag,
                                "Json parsing error: ",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });


            }

        }else {

            //setAuth("Couldn't get json from server. Check LogCat for possible errors!",context_tag);

            Log.d("rknagar",context+" "+context_tag);
            Clientplayer.runOnUI(new Runnable() {
                public void run() {
                    Toast.makeText(context_tag,
                            "Couldn't get json from server. Check LogCat for possible errors!",
                            Toast.LENGTH_LONG)
                            .show();
                }
            });
        }
        return null;
    }

    private void runOnUiThread(Runnable runnable) {

    }


    @Override
    protected void onPostExecute(Void result) {

        super.onPostExecute(result);
        // Dismiss the progress dialog
        if (pDialog.isShowing())
            pDialog.dismiss();
        Profileadapter adapter = new Profileadapter(layout_activity, arrayList);
        Log.d("gujarat", arrayList.toString());
        lv = (ListView) layout_activity.findViewById(R.id.faculty_profile);
        lv.setAdapter(adapter);
    }
    }






