package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

import java.util.concurrent.Callable;

class fx implements Callable {
    final /* synthetic */ fw a;

    fx(fw fwVar) {
        this.a = fwVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        ActivatedController storePageController = new StorePageController(this.a.a.getContext());
        storePageController.loadUrl(p.i().J());
        return storePageController;
    }
}
