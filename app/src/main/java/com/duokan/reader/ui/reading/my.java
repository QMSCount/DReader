package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.reader.domain.document.aj;
import com.duokan.reader.ui.general.p052a.C1317a;

public class my extends FrameLayout implements na {
    /* renamed from: a */
    private mx f10652a;

    public my(Context context, aj ajVar, mx mxVar) {
        int i = 0;
        super(context);
        setWillNotDraw(false);
        setClipChildren(false);
        setStaticTransformationsEnabled(true);
        this.f10652a = mxVar;
        int a = ajVar.mo1415a();
        while (i < a) {
            addView(new bk(getContext(), ajVar.mo1416a(i), i + 1), new LayoutParams(-2, -2, 48));
            i++;
        }
    }

    /* renamed from: a */
    public void mo2431a() {
        if (getVisibility() != 0) {
            clearAnimation();
            setVisibility(0);
            C1317a.m10193a(this, 0.0f, 1.0f, 300, Boolean.valueOf(false), null);
        }
    }

    /* renamed from: b */
    public void mo2433b() {
        if (getVisibility() != 4) {
            clearAnimation();
            C1317a.m10193a(this, 1.0f, 0.0f, 300, Boolean.valueOf(false), new mz(this));
        }
    }

    /* renamed from: c */
    public void mo2434c() {
        clearAnimation();
        setVisibility(4);
    }

    /* renamed from: a */
    public void mo2432a(int i) {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            boolean z;
            bk bkVar = (bk) getChildAt(i2);
            if (i2 == i) {
                z = true;
            } else {
                z = false;
            }
            bkVar.setShowTextView(z);
        }
    }

    public void invalidate() {
        super.invalidate();
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).invalidate();
        }
    }

    protected boolean getChildStaticTransformation(View view, Transformation transformation) {
        PointF a = this.f10652a.mo2437a(this, indexOfChild(view));
        float width = a.x - ((float) (view.getWidth() / 2));
        float f = a.y;
        transformation.clear();
        transformation.setTransformationType(2);
        transformation.getMatrix().setTranslate(width, f);
        return true;
    }
}
