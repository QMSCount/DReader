package com.duokan.reader.ui.personal;

import com.duokan.core.ui.j;
import com.duokan.reader.domain.social.message.aw;
import com.duokan.reader.ui.general.be;

import java.util.List;

class cz implements aw {
    final /* synthetic */ List a;
    final /* synthetic */ j b;
    final /* synthetic */ cy c;

    cz(cy cyVar, List list, j jVar) {
        this.c = cyVar;
        this.a = list;
        this.b = jVar;
    }

    public void a() {
        if (this.a.size() > 0) {
            this.c.b.a.b.removeAll(this.a);
            this.c.b.a(false);
        }
        be.a(this.c.b.getContext(), String.format(this.c.b.getResources().getString(com.duokan.c.j.personal__message_push_view__succeed), new Object[]{Integer.valueOf(this.a.size())}), 0).show();
        this.b.dismiss();
        if (this.c.a != null) {
            this.c.a.run();
        }
    }

    public void a(String str) {
        be.a(this.c.b.getContext(), com.duokan.c.j.personal__message_push_view__fail, 0).show();
    }
}
