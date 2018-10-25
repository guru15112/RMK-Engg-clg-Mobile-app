package com.example.guru.google;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.*;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;
import static com.example.guru.google.Dialogbox.setimagedisplay;

/**
 * Created by Guru on 5/20/2017.
 */

public class Profileadapter extends BaseAdapter {
    private Activity activity;

    private static LayoutInflater inflater=null;

    ArrayList<HashMap<String,  String>> data;
    public Profileadapter(Activity a, ArrayList<HashMap<String, String>> contactList) {
        activity = a;
        data=contactList;

        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    public int getCount() {        return data.size();    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_view_items, null);
        Log.d("Gujarat",data.toString());
        TextView name=(TextView)vi.findViewById(R.id.name);
        TextView profile=(TextView)vi.findViewById(R.id.profile);
        String name1=data.get(position).get("name");
        String profile1=data.get(position).get("profile");
        final String link=data.get(position).get("link");
        name.setText(Html.fromHtml(name1));
        profile.setText(Html.fromHtml(profile1));
        final ImageView image=(ImageView)vi.findViewById(R.id.picture);
        Context context=image.getContext();
        final String picture=data.get(position).get("picture");
        Picasso.with(context.getApplicationContext()).load(picture).transform(new CircleTransform()).into(image);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do your onClick action here
                setimagedisplay(picture,activity);
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // do your onClick action here
                if(link.equals("no")==false)
                {
                    Intent intent = new Intent(activity, Browser_view.class);
                intent.putExtra("key", link);
                activity.startActivity(intent);
                }

            }
        });

        return vi;
    }
}
