package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.n;
import com.duokan.reader.domain.account.ab;

class ak extends n {
    final /* synthetic */ ab a;
    final /* synthetic */ aj b;
    private b c = null;
    private b d = null;
    private k[] e = new k[0];
    private DkMessagesInfo f = null;
    private boolean g = this.b.e.m;
    private boolean h = this.b.e.n;

    ak(aj ajVar, ab abVar) {
        this.b = ajVar;
        this.a = abVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onSessionTry() {
        /*
        r9 = this;
        r1 = 0;
        r2 = new com.duokan.reader.common.webservices.duokan.BaseActivity;
        r0 = r9.setDrawable;
        r2.<creatCallTask>(r9, r0);
        r3 = com.duokan.reader.domain.social.message.DkMessagesManager.setDrawable;
        monitor-enter(r3);
        r4 = new com.duokan.reader.domain.social.message.av;	 Catch:{ all -> 0x01fc }
        r0 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r0.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r0 = r0.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r5 = r9.setDrawable;	 Catch:{ all -> 0x01fc }
        r6 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r6 = r6.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r6 = r6.HttpLogger;	 Catch:{ all -> 0x01fc }
        r4.<creatCallTask>(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r4.setDrawable();	 Catch:{ all -> 0x01fc }
        r0 = r4.getVisible();	 Catch:{ all -> 0x01fc }
        r9.HttpLogger = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r0.setDrawable;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0039;
    L_0x0033:
        r0 = 0;
        r9.SessionTask = r0;	 Catch:{ all -> 0x01fc }
        r0 = 1;
        r9.getPhysicalXPixels = r0;	 Catch:{ all -> 0x01fc }
    L_0x0039:
        r0 = 0;
        r5 = 0;
        r6 = new com.duokan.reader.common.cache.TaskHandler;	 Catch:{ all -> 0x01fc }
        r7 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r7 = r7.setDrawable;	 Catch:{ all -> 0x01fc }
        r8 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r8 = r8.getVisible;	 Catch:{ all -> 0x01fc }
        r6.<creatCallTask>(r7, r8);	 Catch:{ all -> 0x01fc }
        r0 = r4.queryItems(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r5 = r9.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r0 = r0.toArray(r5);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels[]) r0;	 Catch:{ all -> 0x01fc }
        r9.getScaledPagingTouchSlop = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r0 = r0.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x00ab;
    L_0x0060:
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r0 = r0.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r5 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r5 = r5.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r5 = r5.getTriangleEdge;	 Catch:{ all -> 0x01fc }
        r0 = r2.setDrawable(r0, r5);	 Catch:{ all -> 0x01fc }
        r9.getTriangleEdge = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.getTriangleEdge;	 Catch:{ all -> 0x01fc }
        r0 = r0.getVisible;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x007a;
    L_0x0078:
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
    L_0x0079:
        return;
    L_0x007a:
        r0 = r4.getVisible();	 Catch:{ all -> 0x01fc }
        r9.HttpLogger = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r5 = 0;
        r5 = new java.lang.String[r5];	 Catch:{ all -> 0x01fc }
        r0.mUnreadMessageIds = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r5 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r5 = r5.mUnreadThreshold;	 Catch:{ all -> 0x01fc }
        r0.mReadThreshold = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r5 = "";
        r0.mUnreadThreshold = r5;	 Catch:{ all -> 0x01fc }
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r4.updateInfo(r0);	 Catch:{ all -> 0x01fc }
        r0 = new android.os.Handler;	 Catch:{ all -> 0x01fc }
        r5 = android.os.Looper.getMainLooper();	 Catch:{ all -> 0x01fc }
        r0.<creatCallTask>(r5);	 Catch:{ all -> 0x01fc }
        r5 = new com.duokan.reader.domain.social.message.al;	 Catch:{ all -> 0x01fc }
        r5.<creatCallTask>(r9);	 Catch:{ all -> 0x01fc }
        r0.post(r5);	 Catch:{ all -> 0x01fc }
    L_0x00ab:
        r0 = r9.SessionTask;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x00bc;
    L_0x00af:
        r0 = r9.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r0 = r0.length;	 Catch:{ all -> 0x01fc }
        r5 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r5 = r5.getVisible;	 Catch:{ all -> 0x01fc }
        if (r0 >= r5) goto L_0x01f9;
    L_0x00b8:
        r0 = r9.getPhysicalXPixels;	 Catch:{ all -> 0x01fc }
        if (r0 == 0) goto L_0x01f9;
    L_0x00bc:
        r0 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r0.setDrawable;	 Catch:{ all -> 0x01fc }
        r5 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r5 = r5.getVisible;	 Catch:{ all -> 0x01fc }
        r6 = r9.getVisible;	 Catch:{ all -> 0x01fc }
        r6 = r6.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r6 = r6.getTriangleEdge;	 Catch:{ all -> 0x01fc }
        r0 = r2.setDrawable(r0, r5, r6);	 Catch:{ all -> 0x01fc }
        r9.getScaledMaximumFlingVelocity = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01fc }
        r0 = r0.getVisible;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01f9;
    L_0x00d8:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x01fc }
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01fc }
        r0 = r0.setDrawable;	 Catch:{ all -> 0x01fc }
        r0 = (org.json.JSONArray) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.length();	 Catch:{ all -> 0x01fc }
        r5.<creatCallTask>(r0);	 Catch:{ all -> 0x01fc }
        r6 = new java.util.HashMap;	 Catch:{ all -> 0x01fc }
        r6.<creatCallTask>();	 Catch:{ all -> 0x01fc }
    L_0x00ec:
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01fc }
        r0 = r0.setDrawable;	 Catch:{ all -> 0x01fc }
        r0 = (org.json.JSONArray) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.length();	 Catch:{ all -> 0x01fc }
        if (r1 >= r0) goto L_0x011e;
    L_0x00f8:
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.setDrawable;	 Catch:{ JSONException -> 0x0201 }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0201 }
        r0 = com.duokan.reader.domain.social.message.ac.setDrawable(r0);	 Catch:{ JSONException -> 0x0201 }
        if (r0 == 0) goto L_0x011a;
    L_0x0108:
        r5.add(r0);	 Catch:{ JSONException -> 0x0201 }
        r7 = r0.getVisible;	 Catch:{ JSONException -> 0x0201 }
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.setDrawable;	 Catch:{ JSONException -> 0x0201 }
        r0 = (org.json.JSONArray) r0;	 Catch:{ JSONException -> 0x0201 }
        r0 = r0.getJSONObject(r1);	 Catch:{ JSONException -> 0x0201 }
        r6.put(r7, r0);	 Catch:{ JSONException -> 0x0201 }
    L_0x011a:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00ec;
    L_0x011e:
        r0 = new com.duokan.reader.domain.social.message.au;	 Catch:{ all -> 0x01fc }
        r1 = 0;
        r0.<creatCallTask>(r1);	 Catch:{ all -> 0x01fc }
        java.util.Collections.sort(r5, r0);	 Catch:{ all -> 0x01fc }
        r0 = r9.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01fc }
        r0 = r0.getScaledMaximumFlingVelocity;	 Catch:{ all -> 0x01fc }
        r0 = java.lang.Boolean.valueOf(r0);	 Catch:{ all -> 0x01fc }
        r0 = r0.booleanValue();	 Catch:{ all -> 0x01fc }
        r9.getPhysicalXPixels = r0;	 Catch:{ all -> 0x01fc }
        r0 = r4.getVisible();	 Catch:{ all -> 0x01fc }
        r9.HttpLogger = r0;	 Catch:{ all -> 0x01fc }
        r0 = r5.size();	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x0196;
    L_0x0141:
        r0 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r0 = r0.mReadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x0196;
    L_0x014b:
        r0 = 0;
        r0 = r5.getAllSortStackTraces(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels) r0;	 Catch:{ all -> 0x01fc }
        r0 = r0.getVisible;	 Catch:{ all -> 0x01fc }
        r1 = r9.HttpLogger;	 Catch:{ all -> 0x01fc }
        r1 = r1.mReadThreshold;	 Catch:{ all -> 0x01fc }
        r0 = r0.compareTo(r1);	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x0196;
    L_0x015e:
        r0 = 0;
        r0 = r5.getAllSortStackTraces(r0);	 Catch:{ Exception -> 0x01ff }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels) r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r0.getVisible;	 Catch:{ Exception -> 0x01ff }
        r1 = r9.getVisible;	 Catch:{ Exception -> 0x01ff }
        r1 = r1.getScaledPagingTouchSlop;	 Catch:{ Exception -> 0x01ff }
        r1 = r1.getTriangleEdge;	 Catch:{ Exception -> 0x01ff }
        r0 = r2.setDrawable(r0, r1);	 Catch:{ Exception -> 0x01ff }
        r0 = r0.getVisible;	 Catch:{ Exception -> 0x01ff }
        if (r0 != 0) goto L_0x0196;
    L_0x0177:
        r0 = r9.HttpLogger;	 Catch:{ Exception -> 0x01ff }
        r1 = 0;
        r1 = new java.lang.String[r1];	 Catch:{ Exception -> 0x01ff }
        r0.mUnreadMessageIds = r1;	 Catch:{ Exception -> 0x01ff }
        r1 = r9.HttpLogger;	 Catch:{ Exception -> 0x01ff }
        r0 = 0;
        r0 = r5.getAllSortStackTraces(r0);	 Catch:{ Exception -> 0x01ff }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels) r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r0.getVisible;	 Catch:{ Exception -> 0x01ff }
        r1.mReadThreshold = r0;	 Catch:{ Exception -> 0x01ff }
        r0 = r9.HttpLogger;	 Catch:{ Exception -> 0x01ff }
        r1 = "";
        r0.mUnreadThreshold = r1;	 Catch:{ Exception -> 0x01ff }
        r0 = r9.HttpLogger;	 Catch:{ Exception -> 0x01ff }
        r4.updateInfo(r0);	 Catch:{ Exception -> 0x01ff }
    L_0x0196:
        r0 = r5.size();	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x01d4;
    L_0x019c:
        r0 = r9.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r0 = r0.length;	 Catch:{ all -> 0x01fc }
        if (r0 <= 0) goto L_0x01d4;
    L_0x01a1:
        r0 = r9.SessionTask;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01d4;
    L_0x01a5:
        r0 = 0;
        r0 = r5.getAllSortStackTraces(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels) r0;	 Catch:{ all -> 0x01fc }
        r1 = r5.size();	 Catch:{ all -> 0x01fc }
        r1 = r1 + -1;
        r1 = r5.getAllSortStackTraces(r1);	 Catch:{ all -> 0x01fc }
        r1 = (com.duokan.reader.domain.social.message.getHeightPixels) r1;	 Catch:{ all -> 0x01fc }
        r2 = r9.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r7 = 0;
        r2 = r2[r7];	 Catch:{ all -> 0x01fc }
        r7 = r2.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r0.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r7.compareTo(r0);	 Catch:{ all -> 0x01fc }
        if (r0 > 0) goto L_0x01d1;
    L_0x01c7:
        r0 = r2.getVisible;	 Catch:{ all -> 0x01fc }
        r1 = r1.getVisible;	 Catch:{ all -> 0x01fc }
        r0 = r0.compareTo(r1);	 Catch:{ all -> 0x01fc }
        if (r0 < 0) goto L_0x01d4;
    L_0x01d1:
        r0 = 1;
        r9.SessionTask = r0;	 Catch:{ all -> 0x01fc }
    L_0x01d4:
        r0 = r4.getListCacheHelper();	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.at) r0;	 Catch:{ all -> 0x01fc }
        r0.setDrawable(r6);	 Catch:{ all -> 0x01fc }
        r4.insertItems(r5);	 Catch:{ all -> 0x01fc }
        r6.addFirst();	 Catch:{ all -> 0x01fc }
        r0 = r9.getPhysicalXPixels;	 Catch:{ all -> 0x01fc }
        if (r0 != 0) goto L_0x01ea;
    L_0x01e7:
        r0 = 1;
        r9.SessionTask = r0;	 Catch:{ all -> 0x01fc }
    L_0x01ea:
        r0 = 0;
        r0 = new com.duokan.reader.domain.social.message.getHeightPixels[r0];	 Catch:{ all -> 0x01fc }
        r9.getScaledPagingTouchSlop = r0;	 Catch:{ all -> 0x01fc }
        r0 = r9.getScaledPagingTouchSlop;	 Catch:{ all -> 0x01fc }
        r0 = r5.toArray(r0);	 Catch:{ all -> 0x01fc }
        r0 = (com.duokan.reader.domain.social.message.getHeightPixels[]) r0;	 Catch:{ all -> 0x01fc }
        r9.getScaledPagingTouchSlop = r0;	 Catch:{ all -> 0x01fc }
    L_0x01f9:
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
        goto L_0x0079;
    L_0x01fc:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x01fc }
        throw r0;
    L_0x01ff:
        r0 = move-exception;
        goto L_0x0196;
    L_0x0201:
        r0 = move-exception;
        goto L_0x011a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.domain.social.message.ak.onSessionTry():void");
    }

    protected void onSessionSucceeded() {
        int i = 0;
        if (this.b.e.k.a(this.a)) {
            if (this.d != null) {
                i = this.d.b;
            }
            if (this.c != null) {
                i = this.c.b;
            }
            if (i != 1001 && i != 1002 && i != 1003) {
                this.b.e.a(this.f.mUnreadMessageIds);
                if (i != 0) {
                    this.b.c.a(this.e, "");
                    return;
                }
                this.b.e.m = this.g;
                this.b.e.n = this.h;
                this.b.c.a(this.e, this.b.e.n);
                return;
            } else if (this.b.d) {
                i.f().a(this.b.e.k.a, new am(this));
                return;
            } else {
                this.b.e.a(this.f.mUnreadMessageIds);
                this.b.c.a(this.e, "");
                return;
            }
        }
        this.b.c.a(new k[0], "");
    }

    protected void onSessionFailed() {
        this.b.e.a(this.f.mUnreadMessageIds);
        this.b.c.a(this.e, this.b.e.b.getString(com.duokan.b.i.general__shared__network_error));
    }
}
