package com.duokan.reader.ui.general.web;

import android.app.Activity;
import android.graphics.Bitmap;
import android.webkit.JsResult;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.fr;

public interface li {
    Activity getActivity();

    AppContext getContext();

    void onPageFinished(fr frVar, String str);

    void onPageStarted(fr frVar, String str, Bitmap bitmap);

    void setPageTitle(String str);

    void showDialog(String str, boolean z, JsResult jsResult);
}
