package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.AIdleOperation;

class rn implements Runnable {
    final /* synthetic */ qh a;

    rn(qh qhVar) {
        this.a = qhVar;
    }

    public void run() {
        if (!this.a.q && !this.a.h.b()) {
            try {
                this.a.o = true;
                this.a.a();
                this.a.p = true;
                AIdleOperation.addIdleStatus(new ro(this));
            } catch (Throwable e) {
                a.c().a(LogLevel.ERROR, "reading", "an exception occurs during creatCallTask", e);
                throw e;
            }
        }
    }
}
