package com.example.guru.google;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import static com.example.guru.google.R.id.position;

/**
 * Created by Guru venkatesh on 11/22/2017.
 */

public class Dialogbox extends AppCompatActivity{
    public  static void  settextdisplay(TextView content, Context context)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(
                context);

        builder.setMessage(content.getText());
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        //  Toast.makeText(getApplicationContext(),"Yes is clicked",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
     public  static void  setimagedisplay(final String picture, final Activity activity)
     {
         AlertDialog.Builder builder = new AlertDialog.Builder(
                 activity);

         ImageView image2=new ImageView(activity);
        // Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        // Log.d("kohli",bitmap.toString());
        // image2.setImageBitmap(bitmap);
        /* Picasso.with(activity)
                 .load(picture) // Uri of the picture
                 .into(image2);*/
         Picasso.with(activity)
                 .load(picture)
                 .resize(300, 350)
                 .into(image2);
         builder.setView(image2);

         image2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 //setimagedisplay(image,layout_activity);
                 Intent intent = new Intent(activity, GalleryPreview.class);
                 intent.putExtra("path", picture);
                 activity.startActivity(intent);
             }
         });
         builder.create();
         builder.show();
     }
}
