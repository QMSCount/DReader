package com.duokan.core.a;

import com.duokan.core.app.ManagedApp;
import com.duokan.core.app.ManagedApp.RunningState;
import com.duokan.core.app.w;

class o implements w {
    final /* synthetic */ n a;

    o(n nVar) {
        this.a = nVar;
    }

    public void onRunningStateChanged(ManagedApp managedApp, RunningState runningState, RunningState runningState2) {
        if (runningState2.ordinal() > RunningState.BACKGROUND.ordinal()) {
            this.a.h();
        } else if (runningState2.ordinal() < runningState.ordinal()) {
            this.a.i();
        }
    }
}
