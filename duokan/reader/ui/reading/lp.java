package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class lp implements AnimatorUpdateListener {
    final /* synthetic */ lo a;

    lp(lo loVar) {
        this.a = loVar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.a.a.b.c(1.0f - this.a.b);
        this.a.invalidate();
    }
}
