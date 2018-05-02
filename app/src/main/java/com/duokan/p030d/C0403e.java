package com.duokan.p030d;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.ac;
import com.duokan.reader.common.webservices.duokan.p040a.C0626c;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.ClientCookie;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.d.e */
class C0403e extends WebSession {
    /* renamed from: a */
    static final /* synthetic */ boolean f1355a = (!C0402d.class.desiredAssertionStatus());
    /* renamed from: b */
    final /* synthetic */ C0402d f1356b;
    /* renamed from: c */
    private JSONObject f1357c;

    public C0403e(C0402d c0402d) {
        this.f1356b = c0402d;
    }

    protected void onSessionTry() {
        ac acVar = new ac((WebSession) this, (al) null);
        List arrayList = new ArrayList();
        if (ReaderEnv.get().getBuildName().equals("Reader")) {
            arrayList.add(new BasicNameValuePair("package_name", "com.duokan.reader1"));
        } else {
            arrayList.add(new BasicNameValuePair("package_name", this.f1356b.f1353a.getPackageName()));
        }
        arrayList.add(new BasicNameValuePair("build", this.f1356b.m2181c() + ""));
        arrayList.add(new BasicNameValuePair("client_id", C0709k.m3476a().m3514i()));
        arrayList.add(new BasicNameValuePair("sdk", Integer.toString(VERSION.SDK_INT)));
        arrayList.add(new BasicNameValuePair("info", this.f1356b.m2180b()));
        arrayList.add(new BasicNameValuePair("beta", DkApp.get().forCommunity() ? "1" : "0"));
        this.f1357c = acVar.m547a(acVar.mo376a(new C0626c().m2856b(C0641o.m2934i().m2997x()).m2854a(arrayList).m2853a(HttpPost.METHOD_NAME).m2851a()));
    }

    protected void onSessionSucceeded() {
        Object obj = null;
        if (f1355a || this.f1356b.f1354b != null) {
            try {
                String str;
                boolean z;
                Object obj2 = this.f1357c.has("apk") ? (String) this.f1357c.get("apk") : null;
                if (this.f1357c.has(ClientCookie.VERSION_ATTR)) {
                    str = (String) this.f1357c.get(ClientCookie.VERSION_ATTR);
                } else {
                    str = null;
                }
                if (this.f1357c.has("note")) {
                    obj = (String) this.f1357c.get("note");
                }
                if (this.f1357c.has("force") && this.f1357c.getBoolean("force")) {
                    z = true;
                } else {
                    z = false;
                }
                if (TextUtils.isEmpty(obj2) || TextUtils.isEmpty(obj) || TextUtils.isEmpty(str)) {
                    ReaderEnv.get().setNewVersion(0);
                    this.f1356b.f1354b.onNoUpdate();
                    m2186a();
                    return;
                }
                ReaderEnv.get().setNewVersion(Integer.parseInt(str));
                if (Integer.parseInt(str) > this.f1356b.m2181c()) {
                    this.f1356b.f1354b.onUpdate(obj2, obj, z);
                    return;
                }
                this.f1356b.f1354b.onNoUpdate();
                m2186a();
                return;
            } catch (JSONException e) {
                e.printStackTrace();
                return;
            }
        }
        throw new AssertionError();
    }

    protected void onSessionFailed() {
    }

    /* renamed from: a */
    private void m2186a() {
        new C0404f(this).open();
    }
}
