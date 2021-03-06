package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.document.m;

class xz extends yb {
    public xz(IFeature featrue, yh yhVar) {
        super(featrue, yhVar);
        findViewById(g.reading__search_text_view__cancel).setOnClickListener(new ya(this));
        findViewById(g.reading__search_text_view__bar).setPadding(UTools.getMinimumHeight(getContext(), 15.0f), ((ReaderFeature) getContext().queryFeature(ReaderFeature.class)).getTheme().getHeaderPaddingTop() + UTools.getMinimumHeight(getContext(), 10.0f), UTools.getMinimumHeight(getContext(), 15.0f), UTools.getMinimumHeight(getContext(), 10.0f));
    }

    protected void onAttachToStub() {
        m l = this.a.l();
        if (l.c == 0) {
            int argb = (l.i || l.j) ? Color.argb(Math.round(153.0f), 255, 255, 255) : -16777216;
            this.f = argb;
        } else {
            this.f = l.c;
        }
        getContentView().setBackgroundDrawable(((sh) getContext().queryFeature(sh.class)).g() ? new ColorDrawable(-1) : l.a.mutate());
        this.g = Color.argb(Math.round(51.0f), Color.red(this.f), Color.green(this.f), Color.blue(this.f));
        super.onAttachToStub();
    }
}
