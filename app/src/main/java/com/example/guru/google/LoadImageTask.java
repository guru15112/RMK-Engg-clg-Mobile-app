package com.example.guru.google;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by Guru on 5/20/2017.
 */   public class LoadImageTask extends AsyncTask<String, Void, Void> {


    Bitmap image;
ImageView imageView;
LoadImageTask(ImageView image)
{
    imageView=image;
}
    @Override
    protected Void doInBackground(String... args) {

        try {

            image= BitmapFactory.decodeStream((InputStream)new URL(args[0]).getContent());

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        imageView.setImageBitmap(image);

    }


}

