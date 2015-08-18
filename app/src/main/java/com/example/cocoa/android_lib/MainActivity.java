package com.example.cocoa.android_lib;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.cocoa.util.L;
import com.example.cocoa.util.Logger;

import java.io.IOException;

public class MainActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try {
            Logger logger = new Logger(this,"API.txt");
            logger.writeContent("this content")
            .writeTilte("this is title").commit();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        SharedPreferences sp = getSharedPreferences("11", 1);
//        SharedPreferences.Editor e = sp.edit();
//        L.dn("111",e.getClass()+"");
//        SharedPreferencesImpl

        TextView  view  = new TextView(this);

    }


    public void animTest(View view){
        startActivity(new Intent(this,ActivityAnimTest.class));
    }


}
