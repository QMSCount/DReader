package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.drawable.InsetDrawable;

import com.duokan.c.d;
import com.duokan.c.j;
import com.duokan.core.app.x;
import com.duokan.core.ui.dv;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.cloud.push.b;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.s;

class ct extends nm {
    final /* synthetic */ cr a;

    public ct(cr crVar, Context context, ho hoVar) {
        this.a = crVar;
        super(context, hoVar);
        this.b.setVisibility(8);
        this.c.setVisibility(8);
        this.e.setRowDivider(new InsetDrawable(new dk(getResources().getColor(d.general__shared__e9e9e9)), dv.b(getContext(), 3.0f), 0, 0, 0));
        setBackgroundColor(getContext().getResources().getColor(d.general__shared__ff6518));
        s sVar = (s) x.a(getContext()).queryFeature(s.class);
        int b;
        if (ReaderEnv.get().forHd()) {
            b = dv.b(getContext(), 15.0f);
            this.e.a(b, 0, b, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        } else {
            b = dv.b(getContext(), 10.0f);
            this.e.a(b, 0, b, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
        }
        this.e.setOnItemClickListener(new cu(this, crVar));
        this.e.setOnItemLongPressListener(new cv(this, crVar));
        setAdapter(new cw(this, crVar));
    }

    public void a() {
        this.e.setPullDownRefreshEnabled(false);
    }

    public void b() {
        this.e.setPullDownRefreshEnabled(true);
    }

    private void a(int i, long j) {
        b.a().a(i, j, new cx(this, i, j));
    }

    public void a(Runnable runnable) {
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.personal__message_push_view__delete_multiple);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new cy(this, runnable));
    }
}
