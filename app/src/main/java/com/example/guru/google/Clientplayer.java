package com.example.guru.google;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;



/**
 * Created by Guru venkatesh on 12/5/2017.
 */

public class Clientplayer extends Activity {

public static Handler UIHandler;

static
{
        UIHandler = new Handler(Looper.getMainLooper());
        }
public static void runOnUI(Runnable runnable) {
        UIHandler.post(runnable);
        }

        }