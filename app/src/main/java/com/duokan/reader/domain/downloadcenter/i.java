package com.duokan.reader.domain.downloadcenter;

import com.duokan.core.sys.t;

import java.util.Iterator;

class i implements Runnable {
    final /* synthetic */ b a;

    i(b bVar) {
        this.a = bVar;
    }

    public void run() {
        Iterator it = this.a.f.iterator();
        Object obj = null;
        while (it.hasNext()) {
            DownloadCenterTask downloadCenterTask = (DownloadCenterTask) it.next();
            if (downloadCenterTask.d()) {
                obj = 1;
                this.a.e(downloadCenterTask);
            }
            obj = obj;
        }
        if (obj != null) {
            t.a((Runnable) this, 1000);
            return;
        }
        t.c(this.a.i);
        this.a.i = null;
    }
}