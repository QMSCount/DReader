package com.duokan.reader.domain.account;

import android.view.View;
import android.view.View.OnClickListener;

class x implements OnClickListener {
    final /* synthetic */ PersonalAccount a;
    final /* synthetic */ b b;
    final /* synthetic */ w c;

    x(w wVar, PersonalAccount personalAccount, b bVar) {
        this.c = wVar;
        this.a = personalAccount;
        this.b = bVar;
    }

    public void onClick(View view) {
        a.d().a("setDrawable");
        this.c.dismiss();
        this.a.d(this.b);
    }
}
