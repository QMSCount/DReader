package com.duokan.reader.ui.account;

import com.duokan.core.ui.BaseDialog;
import com.duokan.core.ui.OnDismissListener;

class ad implements OnDismissListener {
    /* renamed from: a */
    final /* synthetic */ ab f5778a;

    ad(ab abVar) {
        this.f5778a = abVar;
    }

    public void onDismiss(BaseDialog dialog) {
        this.f5778a.f5774a.onChoiced(this.f5778a.f5776c);
    }
}
