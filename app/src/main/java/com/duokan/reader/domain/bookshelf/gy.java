package com.duokan.reader.domain.bookshelf;

import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.io.FileUtil;
import com.duokan.core.p027b.p028a.HttpConfig;
import com.duokan.core.p027b.p028a.C0321b;
import java.io.File;

class gy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ File f3271a;
    /* renamed from: b */
    final /* synthetic */ int f3272b;
    /* renamed from: c */
    final /* synthetic */ gx f3273c;

    gy(gx gxVar, File file, int i) {
        this.f3273c = gxVar;
        this.f3271a = file;
        this.f3272b = i;
    }

    public void run() {
        this.f3271a.getParentFile().mkdirs();
        try {
            FileUtil.deleteFile(this.f3271a);
            C0321b.getFileLength(this.f3273c.f3270b.f2718b, this.f3271a, new HttpConfig().m721a(this.f3272b).m724b(131072));
        } catch (Throwable th) {
            WebLog.init().printStackTrace(LogLevel.ERROR, "epub-l", "fail to download the book " + this.f3273c.f3270b.f2718b, th);
        }
    }
}
