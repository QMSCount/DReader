package com.duokan.core.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;

public class TabBarView extends FrameLayout {
    
    private Drawable f856a;
    
    private int tabIndex;
    
    private int lastTabIndex;
    
    private TranslateAnimation translateAnimation;
    
    private TranslateAnimation f860e;
    
    public final bt childView;
    
    private int indicatorCenter;
    
    private int indictorWidth;
    
    private int gravity;
    
    private cs f865j;
    
    private Transformation f866k;
    
    private Rect f867l;
    
    private boolean repeatedClicks;

    public TabBarView(Context context) {
        this(context, null);
    }

    public TabBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f856a = null;
        this.tabIndex = -1;
        this.lastTabIndex = -1;
        this.translateAnimation = null;
        this.f860e = null;
        this.indicatorCenter = 0;
        this.indictorWidth = 0;
        this.gravity = 23;
        this.f865j = null;
        this.f866k = new Transformation();
        this.f867l = new Rect(0, 0, 0, 0);
        this.repeatedClicks = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842948});
        CharSequence string = obtainStyledAttributes.hasValue(0) ? obtainStyledAttributes.getString(0) : "horizontal";
        obtainStyledAttributes.recycle();
        if (TextUtils.equals(string, "horizontal")) {
            this.childView = new HorzLinearView(context);
        } else {
            this.childView = new MyListView(context);
        }
        addView(this.childView, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public TabBarView(Context context, int i) {
        super(context);
        this.f856a = null;
        this.tabIndex = -1;
        this.lastTabIndex = -1;
        this.translateAnimation = null;
        this.f860e = null;
        this.indicatorCenter = 0;
        this.indictorWidth = 0;
        this.gravity = 23;
        this.f865j = null;
        this.f866k = new Transformation();
        this.f867l = new Rect(0, 0, 0, 0);
        this.repeatedClicks = true;
        if (i == 1) {
            this.childView = new MyListView(context);
        } else {
            this.childView = new HorzLinearView(context);
        }
        addView(this.childView, new LayoutParams(-1, -1));
        setWillNotDraw(false);
    }

    public int getSelectedTabIndex() {
        return this.tabIndex;
    }

    public int getTabCount() {
        return this.childView.getCellCount();
    }

    public void setIndicatorGravity(int gravity ) {
        this.gravity = gravity;
        invalidate();
    }

    public ScaleType getDividerScaleType() {
        return this.childView.getDividerScaleType();
    }

    public void setDividerScaleType(ScaleType scaleType) {
        this.childView.setDividerScaleType(scaleType);
        requestLayout();
        invalidate();
    }

    public Drawable getFirstDividerDrawable() {
        return this.childView.getFirstDivider();
    }

    public void setFirstDividerDrawable(int i) {
        setFirstDividerDrawable(getResources().getDrawable(i));
    }

    public void setFirstDividerDrawable(Drawable drawable) {
        this.childView.setFirstDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getMiddleDividerDrawable() {
        return this.childView.getMiddleDivider();
    }

    public void setMiddleDividerDrawable(int i) {
        setMiddleDividerDrawable(getResources().getDrawable(i));
    }

    public void setMiddleDividerDrawable(Drawable drawable) {
        this.childView.setMiddleDivider(drawable);
        requestLayout();
        invalidate();
    }

    public Drawable getLastDividerDrawable() {
        return this.childView.getLastDivider();
    }

    public void setLastDividerDrawable(int i) {
        setLastDividerDrawable(getResources().getDrawable(i));
    }

    public void setLastDividerDrawable(Drawable drawable) {
        this.childView.setLastDivider(drawable);
        requestLayout();
        invalidate();
    }

    public void setIgnoreRepeatedClicks(boolean z) {
        this.repeatedClicks = z;
    }

    
    public int m1319a(int i) {
        int i2 = this.tabIndex;
        changeTabStatus(i, false);
        return i2;
    }

    
    public View m1322c(int i) {
        ViewGroup a = m1306a();
        LayoutInflater.from(getContext()).inflate(i, a, true);
        if (this.childView.getChildCount() == 1) {
            changeTabStatus(0, false);
        }
        return a.getChildAt(0);
    }

    
    public int m1320a(View view) {
        if (view.getLayoutParams() == null) {
            view.setLayoutParams(new LayoutParams(-1, -1));
        }
        m1306a().addView(view);
        if (this.childView.getChildCount() == 1) {
            changeTabStatus(0, false);
        }
        return this.childView.getChildCount() - 1;
    }

    public void setIndicatorDrawable(int i) {
        setIndicatorDrawable(getResources().getDrawable(i));
    }

    public void setIndicatorDrawable(Drawable drawable) {
        this.f856a = drawable;
        invalidate();
    }

    public void setSelectionChangeListener(cs csVar) {
        this.f865j = csVar;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f856a != null && this.tabIndex >= 0) {
            m1314b();
            m1316c();
            m1309a(canvas);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f856a != null) {
            switchTabView(null, false);
        }
    }

    public void setTabEnabled(boolean z) {
        for (int i = 0; i < this.childView.getCellCount(); i++) {
            this.childView.getTabView(i).setEnabled(z);
        }
    }

    
    private void changeTabStatus(int tabIndex, boolean isSelected) {
        if (this.tabIndex != tabIndex || !this.repeatedClicks) {
            FrameLayout tabView;
            this.lastTabIndex = this.tabIndex;
            if (this.tabIndex >= 0) {
                tabView = getChildTabView(this.tabIndex);
                tabView.setSelected(false);
                tabView.getChildAt(0).setSelected(false);
            }
            tabView = null;
            if (tabIndex >= 0) {
                tabView = getChildTabView(tabIndex);
                this.tabIndex = tabIndex;
            }
            switchTabView(tabView, isSelected);
            if (this.f865j != null) {
                this.f865j.mo1697a(this.lastTabIndex, this.tabIndex, isSelected);
            }
        }
    }

    
    private void switchTabView(FrameLayout frameLayout, boolean select) {
        if (this.tabIndex < 0) {
            this.translateAnimation = null;
            this.f860e = null;
            setIndicatorCenter(0);
            setIndicatorWidth(0);
            invalidate();
        } else if (this.f856a == null || getVisibility() != 0) {
            if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
            post(new cn(this, select));
        } else {
            Rect selectedTabRect = getSelectedTabRect();
            if (!m1317c(selectedTabRect)) {
                if (this.childView instanceof MyListView) {
                    this.translateAnimation = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorCenter(), (float) m1303a(selectedTabRect));
                    this.f860e = new TranslateAnimation(0.0f, 0.0f, (float) getIndicatorWidth(), (float) m1312b(selectedTabRect));
                } else {
                    this.translateAnimation = new TranslateAnimation((float) getIndicatorCenter(), (float) m1303a(selectedTabRect), 0.0f, 0.0f);
                    this.f860e = new TranslateAnimation((float) getIndicatorWidth(), (float) m1312b(selectedTabRect), 0.0f, 0.0f);
                }
                this.translateAnimation.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.translateAnimation.setDuration(200);
                this.translateAnimation.setFillAfter(true);
                this.translateAnimation.setFillEnabled(true);
                this.translateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f860e.initialize(selectedTabRect.width(), selectedTabRect.height(), getWidth(), getHeight());
                this.f860e.setDuration(200);
                this.f860e.setFillAfter(true);
                this.f860e.setFillEnabled(true);
                this.f860e.setInterpolator(new AccelerateDecelerateInterpolator());
                this.f860e.setAnimationListener(new co(this, frameLayout, select));
                invalidate();
            } else if (frameLayout != null) {
                frameLayout.setSelected(true);
                frameLayout.getChildAt(0).setSelected(true);
            }
        }
    }

    private Rect getSelectedTabRect() {
        if (this.tabIndex < 0) {
            return new Rect(0, 0, 0, 0);
        }
        Rect rect = new Rect();
        AnimUtils.m1906a(new RectF(), childView.getView(this.tabIndex, this), (View) this).round(rect);
        return rect;
    }

    
    private int m1303a(Rect rect) {
        if (this.childView instanceof MyListView) {
            return rect.centerY();
        }
        return rect.centerX();
    }

    
    private FrameLayout m1306a() {
        View frameLayout = new FrameLayout(getContext());
        frameLayout.setOnClickListener(new cq(this));
        frameLayout.setOnTouchListener(new cr(this));
        this.childView.mo455a(frameLayout, new LinearLayout.LayoutParams(-1, -1, 1.0f));
        return frameLayout;
    }

    
    private int m1304a(FrameLayout frameLayout) {
        for (int i = 0; i < this.childView.getCellCount(); i++) {
            if (this.childView.getTabView(i) == frameLayout) {
                return i;
            }
        }
        return -1;
    }

    
    private FrameLayout getChildTabView(int i) {
        return (FrameLayout) this.childView.getTabView(i);
    }

    
    protected void m1323d(int i) {
        setIndicatorCenter(i);
        invalidate();
    }

    private int getIndicatorCenter() {
        return this.indicatorCenter;
    }

    private void setIndicatorCenter(int i) {
        this.indicatorCenter = i;
    }

    private int getIndicatorWidth() {
        return this.indictorWidth;
    }

    private void setIndicatorWidth(int i) {
        this.indictorWidth = i;
    }

    
    private void m1314b() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.translateAnimation != null && !this.translateAnimation.hasEnded()) {
            if (!this.translateAnimation.hasStarted()) {
                this.translateAnimation.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.translateAnimation.getTransformation(currentAnimationTimeMillis, this.f866k);
            this.f866k.getMatrix().mapPoints(fArr);
            if (this.childView instanceof MyListView) {
                this.indicatorCenter = Math.round(fArr[1]);
            } else {
                this.indicatorCenter = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    
    private void m1316c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f860e != null && !this.f860e.hasEnded()) {
            if (!this.f860e.hasStarted()) {
                this.f860e.setStartTime(currentAnimationTimeMillis);
            }
            float[] fArr = new float[]{0.0f, 0.0f};
            this.f860e.getTransformation(currentAnimationTimeMillis, this.f866k);
            this.f866k.getMatrix().mapPoints(fArr);
            if (this.childView instanceof MyListView) {
                this.indictorWidth = Math.round(fArr[1]);
            } else {
                this.indictorWidth = Math.round(fArr[0]);
            }
            invalidate();
        }
    }

    
    private void m1309a(Canvas canvas) {
        canvas.save();
        if (this.childView instanceof MyListView) {
            this.f867l.set(0, this.indicatorCenter - (this.indictorWidth / 2), getWidth(), this.indicatorCenter + ((this.indictorWidth + 1) / 2));
        } else {
            this.f867l.set(this.indicatorCenter - (this.indictorWidth / 2), 0, this.indicatorCenter + ((this.indictorWidth + 1) / 2), getHeight());
        }
        AnimUtils.m1911a(canvas, this.f856a, this.f867l, this.gravity);
        canvas.restore();
    }

    
    private int m1312b(Rect rect) {
        if (this.childView instanceof MyListView) {
            return rect.height();
        }
        return rect.width();
    }

    
    private boolean m1317c(Rect rect) {
        if (this.childView instanceof MyListView) {
            if (this.indicatorCenter == rect.centerY() && this.indictorWidth == rect.height()) {
                return true;
            }
            return false;
        } else if (this.indicatorCenter == rect.centerX() && this.indictorWidth == rect.width()) {
            return true;
        } else {
            return false;
        }
    }
}
