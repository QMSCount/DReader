package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.cloud.PersonalPrefs;

import java.util.concurrent.Callable;

class gu implements Callable {
    final /* synthetic */ PageController a;

    gu(PageController cgVar) {
        this.a = cgVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        return Boolean.valueOf(PersonalPrefs.a().x());
    }
}
