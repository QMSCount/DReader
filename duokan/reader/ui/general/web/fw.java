package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;

import org.json.JSONObject;

class fw implements ag {
    final /* synthetic */ fv a;

    fw(fv fvVar) {
        this.a = fvVar;
    }

    public void a(JSONObject jSONObject) {
        this.a.a.b.pageController.triggerEventOnCurrentUrl("commentCommit", jSONObject);
    }
}
