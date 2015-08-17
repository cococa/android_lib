package com.example.cocoa.util;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by Administrator on 2015/8/17.
 */
public class MetadataReader {


    /**
     *  <application...>
        <meta-data android:value="hello my application" android:name="myMsg"></meta-data>
     * get application meta-data TAG
     * @param name
     * @return
     */
    private String getDetadata(Application context,String name) throws PackageManager.NameNotFoundException{
        ApplicationInfo appInfo = context.getPackageManager()
                .getApplicationInfo(context.getPackageName(),
                        PackageManager.GET_META_DATA);
        return  appInfo.metaData.getString(name);
    }




}
