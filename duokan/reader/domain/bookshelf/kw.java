package com.duokan.reader.domain.bookshelf;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class kw implements u {
    final /* synthetic */ kp a;

    kw(kp kpVar) {
        this.a = kpVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.a.i = new kx(this, new ab(aVar));
        this.a.i.open();
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.e();
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.b, (CharSequence) str, 0).show();
        }
    }
}
