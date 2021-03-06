package com.duokan.common;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Build.VERSION;

@SuppressLint({"NewApi"})
public abstract class Execute {
    public static void run(AsyncTask asyncTask, Object... objArr) {
        if (VERSION.SDK_INT >= 11) {
            asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, objArr);
        } else {
            asyncTask.execute(objArr);
        }
    }
}
