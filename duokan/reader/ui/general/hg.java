package com.duokan.reader.ui.general;

import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;

class hg extends hj {
    final /* synthetic */ hd a;
    private final FrameLayout c;

    public hg(hd hdVar, IFeature featrue, ActivatedController activatedControllerVar, int i, int i2) {
        this.a = hdVar;
        super(hdVar, featrue, activatedControllerVar);
        this.c = new hh(this, getContext(), hdVar, i);
        this.c.setOnTouchListener(new hi(this, hdVar, i2));
        setContentView(this.c);
        this.c.addView(b(), new LayoutParams(-1, -1, i));
        addSubController(a());
        activate(a());
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.c.removeAllViews();
    }
}
