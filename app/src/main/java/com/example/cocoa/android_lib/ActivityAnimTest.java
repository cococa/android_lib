package com.example.cocoa.android_lib;


import android.app.SearchManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cocoa.util.Logger;
import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;


import java.io.IOException;

public class ActivityAnimTest extends FragmentActivity implements View.OnClickListener{

//    PROXY_PROPERTIES.put("alpha", PreHoneycombCompat.ALPHA);
//    PROXY_PROPERTIES.put("pivotX", PreHoneycombCompat.PIVOT_X);
//    PROXY_PROPERTIES.put("pivotY", PreHoneycombCompat.PIVOT_Y);
//    PROXY_PROPERTIES.put("translationX", PreHoneycombCompat.TRANSLATION_X);
//    PROXY_PROPERTIES.put("translationY", PreHoneycombCompat.TRANSLATION_Y);
//    PROXY_PROPERTIES.put("rotation", PreHoneycombCompat.ROTATION);
//    PROXY_PROPERTIES.put("rotationX", PreHoneycombCompat.ROTATION_X);
//    PROXY_PROPERTIES.put("rotationY", PreHoneycombCompat.ROTATION_Y);
//    PROXY_PROPERTIES.put("scaleX", PreHoneycombCompat.SCALE_X);
//    PROXY_PROPERTIES.put("scaleY", PreHoneycombCompat.SCALE_Y);
//    PROXY_PROPERTIES.put("scrollX", PreHoneycombCompat.SCROLL_X);
//    PROXY_PROPERTIES.put("scrollY", PreHoneycombCompat.SCROLL_Y);
//    PROXY_PROPERTIES.put("x", PreHoneycombCompat.X);
//    PROXY_PROPERTIES.put("y", PreHoneycombCompat.Y);

    private ImageView img1;
    private int width;
    private int height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animtest);
        DisplayMetrics metric = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metric);
         width = metric.widthPixels;     // 屏幕宽度（像素）  
         height = metric.heightPixels;   // 屏幕高度（像素）  
        img1 = (ImageView) findViewById(R.id.img1);
        img1.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img1:
                //这里Y轴不会到中间，应该是状态栏和titlebar 的问题
                int vHeight=v.getHeight();
                int vWidth = v.getWidth();
                ObjectAnimator animX = ObjectAnimator.ofFloat(v, "x", (width - vWidth) / 2);
                ObjectAnimator animY = ObjectAnimator.ofFloat(v, "y", (height-vHeight)/2);
                ObjectAnimator alpha = ObjectAnimator.ofFloat(v,"alpha",1F,0.5F);
                ObjectAnimator rotation = ObjectAnimator.ofFloat(v,"rotation",0F,360F*3);
                animX.setDuration(1*1000);
                animY.setDuration(1*1000);
                alpha.setDuration(1*1000);
                rotation.setDuration(1*1000);
                AnimatorSet animSetXY = new AnimatorSet();
                animSetXY.playTogether(animX,animY,alpha,rotation);
                animSetXY.start();


                break;

            default:
                break;

        }
    }
}
