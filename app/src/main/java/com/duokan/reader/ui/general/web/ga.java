package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.ag;

import org.json.JSONObject;

class ga implements ag {
    final /* synthetic */ fz a;

    ga(fz fzVar) {
        this.a = fzVar;
    }

    public void a(JSONObject jSONObject) {
        this.a.b.b.triggerEventOnCurrentUrl("feedCommit", jSONObject);
    }
}
