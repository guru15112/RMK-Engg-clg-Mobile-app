package com.example.guru.google;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.*;
import java.util.ArrayList;
import java.util.HashMap;

import static android.content.ContentValues.TAG;
import static android.content.Context.TELECOM_SERVICE;
import static com.example.guru.google.Dialogbox.setimagedisplay;
import static com.example.guru.google.Dialogbox.settextdisplay;

/**
 * Created by Guru on 5/20/2017.
 */

public class Newsadapter extends BaseAdapter {
    private Activity activity;

    private static LayoutInflater inflater=null;

    ArrayList<HashMap<String, String>> data;
    public Newsadapter(Activity a, ArrayList<HashMap<String, String>> contactList) {
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
        Log.e(TAG, "check2" + " hello");
        View vi=convertView;
        if(convertView==null)
            vi = inflater.inflate(R.layout.list_item, null);

        final TextView content=(TextView)vi.findViewById(R.id.content);
final String content_info=data.get(position).get("content");
       // TextView link=(TextView)vi.findViewById(R.id.link);
        content.setText(content_info);
       // link.setText(data.get(position).get("link"));
        ImageView image=(ImageView)vi.findViewById(R.id.picture);
        if(data.get(position).get("link").equals("jpg")) {

              Log.e(TAG, "check3" + data.get(position).get("link"));
              //  new LoadImageTask(image).execute(data.get(position).get("photo"));


                Context context=image.getContext();
                final String picture=data.get(position).get("photo");
                Picasso.with(context.getApplicationContext()).load(data.get(position).get("photo")).into(image);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // do your onClick action here

                    setimagedisplay(picture,activity);
                }
            });
            // imageLoader.DisplayImage(data[position], image);
        }// imageLoader.DisplayImage(data[position], image);
        else if(data.get(position).get("link").equals("pdf"))
        {

            Context context=image.getContext();
            image.setImageResource(R.drawable.pdf);

        }
        else
        {

            Context context=image.getContext();
            image.setImageResource(R.drawable.link);

        }
        content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settextdisplay(content,activity);
            }
        });

        return vi;
    }
}
