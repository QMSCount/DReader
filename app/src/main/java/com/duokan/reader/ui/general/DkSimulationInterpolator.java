package com.duokan.reader.ui.general;

import android.view.animation.Interpolator;
import org.apache.http.HttpStatus;

public class DkSimulationInterpolator implements Interpolator {
    /* renamed from: b */
    private static final float[] f6787b = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    /* renamed from: c */
    private static final float[] f6788c = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    /* renamed from: a */
    private final Mode f6789a;

    public enum Mode {
        ACCELERATE,
        DECELERATE
    }

    public DkSimulationInterpolator(Mode mode) {
        this.f6789a = mode;
    }

    public float getInterpolation(float f) {
        float max = Math.max(0.0f, Math.min(f, 1.0f));
        switch (bb.f6964a[this.f6789a.ordinal()]) {
            case 1:
                max = 1.0f - max;
                break;
        }
        int i = (int) (300.0f * max);
        if (i < HttpStatus.SC_MULTIPLE_CHOICES) {
            float f2 = ((float) i) / 300.0f;
            float f3 = ((float) (i + 1)) / 300.0f;
            float f4 = f6787b[i];
            max = ((max - f2) * ((f6787b[i + 1] - f4) / (f3 - f2))) + f4;
        } else {
            max = 1.0f;
        }
        switch (bb.f6964a[this.f6789a.ordinal()]) {
            case 1:
                return 1.0f - max;
            default:
                return max;
        }
    }

    static {
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < HttpStatus.SC_MULTIPLE_CHOICES) {
            float f3;
            float f4 = ((float) i) / 300.0f;
            float f5 = 1.0f;
            float f6 = f2;
            while (true) {
                f2 = ((f5 - f6) / 2.0f) + f6;
                f3 = (3.0f * f2) * (1.0f - f2);
                float f7 = ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f6 = f2;
                }
            }
            f6787b[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
            f5 = 1.0f;
            while (true) {
                f2 = ((f5 - f) / 2.0f) + f;
                f3 = (3.0f * f2) * (1.0f - f2);
                f7 = ((((1.0f - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f = f2;
                }
            }
            f6788c[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f6787b;
        f6788c[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
        fArr[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
    }
}
