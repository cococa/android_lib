package com.example.cocoa.util;

import android.util.Log;

/**
 * Created by Administrator on 2015/8/17.
 */
public final class L {
    //
    private L(){}

    public static void d(String LOG_TAG,String message){
        Log.d(LOG_TAG,message);
    }

    public static void dn(String LOG_TAG,String message){
        Log.d(LOG_TAG,"-------------------"+LOG_TAG+"-----------------------------");
        Log.d(LOG_TAG,message);
        Log.d(LOG_TAG,"-------------------"+LOG_TAG+"-----------------------------");
    }

    public static void e(String LOG_TAG,String message){
        Log.e(LOG_TAG, message);
    }
    public static void w(String LOG_TAG,String message){
        Log.w(LOG_TAG, message);
    }
    public static void i(String LOG_TAG,String message){
        Log.i(LOG_TAG, message);
    }
    public static void v(String LOG_TAG,String message){
        Log.v(LOG_TAG, message);
    }


}
