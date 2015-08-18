package com.example.cocoa.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Environment;

import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import Config.Config;

/**
 * 日志记录
 * Created by Administrator on 2015/8/17.
 */
public class Logger {
    private File file;

    /**
     * 初始化日志文件
     *
     * @param context
     * @throws IOException
     */
    public Logger(Context context,String uniqueName ) throws IOException {
        file = getDiskCacheDir(context,uniqueName);
        if (!file.exists()) {
            file.createNewFile();
        }
    }

    /**
     * 创建缓存目录
     *
     * @param context
     * @param uniqueName 文件名
     * @return
     */
    public File getDiskCacheDir(Context context, String uniqueName) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath + File.separator + uniqueName);
    }

    private String title;
    private String content;


    public Logger writeTilte(String title) {
        this.title = title;
        return this;
    }

    public Logger writeContent(String content) {
        this.content = content;
        return this;
    }

    public void commit() throws IOException {
        synchronized (this) {
            FileWriter writer = new FileWriter(file, true);
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(System.currentTimeMillis());
            writer.write("\n");
            writer.write("\n");
            writer.write("---" + date + ">>>" + this.title + "---");
            writer.write("\n");
            writer.write(content);
            writer.flush();
            if (writer != null) {
                writer.close();
                writer = null;
            }
            title = null;
            content = null;
        }
    }

    public void clear() throws IOException {
        synchronized (this) {
            FileWriter writer = new FileWriter(file);
            writer.write("");
            writer.flush();
            if (writer != null) {
                writer.close();
                writer = null;
            }
        }
    }


}
