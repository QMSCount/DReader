package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.mipay.sdk.Mipay;

class dq implements u {
    final /* synthetic */ dp a;

    dq(dp dpVar) {
        this.a = dpVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.a.b.b.a(this.a.a, aVar);
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.b.b.b.web_notifyWeb(this.a.a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
    }
}
