package com.duokan.reader.ui.reading;

import android.view.View;
import android.view.View.OnClickListener;

class wd implements OnClickListener {
    final /* synthetic */ vq a;

    wd(vq vqVar) {
        this.a = vqVar;
    }

    public void onClick(View view) {
        boolean z;
        boolean z2 = true;
        if (view.isSelected()) {
            z = false;
        } else {
            z = true;
        }
        view.setSelected(z);
        ReadingPrefs ae = this.a.a.ae();
        if (this.a.a.ae().H()) {
            z2 = false;
        }
        ae.c(z2);
        this.a.a.ae().Y();
    }
}
