package com.duokan.core.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.duokan.core.sys.aa;
import com.duokan.core.sys.t;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class e {
    static final /* synthetic */ boolean $assertionsDisabled = (!e.class.desiredAssertionStatus());
    private final CopyOnWriteArrayList mActivatedControllers;
    private boolean mActive;
    private final Activity mActivity;
    private View mContentView;
    private final g mContext;
    private final aa mDelayedRunnableQueue;
    private boolean mFirstActive;
    private WeakReference mMenuShownRef;
    private h mParent;
    private Runnable mRunBeforeDetach;
    private final h mSubControllerParent;
    private final ArrayList mSubControllers;

    public e(y yVar, int i) {
        this(yVar);
        setContentView(i);
    }

    public e(y yVar) {
        this.mSubControllers = new ArrayList();
        this.mActivatedControllers = new CopyOnWriteArrayList();
        this.mDelayedRunnableQueue = new aa();
        this.mParent = null;
        this.mMenuShownRef = null;
        this.mContentView = null;
        this.mActive = false;
        this.mFirstActive = true;
        this.mContext = new g(yVar, this);
        this.mActivity = (Activity) this.mContext.getBaseContext();
        this.mSubControllerParent = newSubControllerParent();
        if (this instanceof k) {
            getContext().a((k) this);
        }
    }

    public final x getContext() {
        return this.mContext;
    }

    public final h getParent() {
        return this.mParent;
    }

    public final void setParent(h hVar) {
        if (this.mParent != hVar) {
            this.mParent = hVar;
            if (this.mParent == null) {
                dispatchDetachFromStub();
            } else if (isAttached()) {
                dispatchAttachToStub();
            }
        }
    }

    public final Activity getActivity() {
        return this.mActivity;
    }

    public final View getContentView() {
        return this.mContentView;
    }

    public final void setContentView(int i) {
        this.mContentView = LayoutInflater.from(getContext()).inflate(i, null);
    }

    public final void setContentView(View view) {
        this.mContentView = view;
    }

    public final Resources getResources() {
        return getContext().getResources();
    }

    public final void runLater(Runnable runnable) {
        t.b(runnable);
    }

    public final void runLater(Runnable runnable, long j) {
        t.a(runnable, j);
    }

    public final boolean runAfterActive(Runnable runnable) {
        if (isActive()) {
            runnable.run();
            return true;
        }
        this.mDelayedRunnableQueue.a(runnable);
        return false;
    }

    public final boolean runFirstOnActive(String str, Runnable runnable) {
        if (isActive()) {
            runnable.run();
            return true;
        }
        this.mDelayedRunnableQueue.b(str, runnable);
        return false;
    }

    public final boolean runLastOnActive(String str, Runnable runnable) {
        if (isActive()) {
            runnable.run();
            return true;
        }
        this.mDelayedRunnableQueue.c(str, runnable);
        return false;
    }

    public final boolean isDelayedRunnableOnActive(Runnable runnable) {
        return this.mDelayedRunnableQueue.b(runnable);
    }

    public final boolean isActive() {
        return this.mActive;
    }

    public final void runBeforeDetach(Runnable runnable) {
        this.mRunBeforeDetach = runnable;
    }

    public final boolean isAttached() {
        for (h hVar = this.mParent; hVar != null; hVar = hVar.getParent()) {
            if (hVar.isStub()) {
                return true;
            }
        }
        return false;
    }

    public final boolean isMenuShowing() {
        e menuShownController = menuShownController();
        if (menuShownController == this) {
            return onCheckMenuShowing();
        }
        return menuShownController != null && menuShownController.isMenuShowing();
    }

    public final void requestBack() {
        if (!getActivity().isFinishing()) {
            getActivity().onBackPressed();
        }
    }

    public final void requestShowMenu() {
        if (this.mParent != null) {
            this.mParent.requestShowMenu(this);
        } else {
            doShowMenu();
        }
    }

    public final void requestHideMenu() {
        if (this.mParent != null) {
            this.mParent.requestHideMenu(this);
        } else if (isMenuShowing()) {
            doHideMenu();
        }
    }

    public final boolean requestDetach() {
        if (this.mParent != null) {
            return this.mParent.requestDetach(this);
        }
        return false;
    }

    public final void activate(e eVar) {
        if (!$assertionsDisabled && eVar == null) {
            throw new AssertionError();
        } else if (eVar != null && eVar.getParent() == this.mSubControllerParent) {
            this.mActivatedControllers.remove(eVar);
            this.mActivatedControllers.add(eVar);
            if (this.mActive && !eVar.isActive()) {
                eVar.gotoActive();
            }
        }
    }

    public final void deactivate(e eVar) {
        if (!$assertionsDisabled && eVar == null) {
            throw new AssertionError();
        } else if (eVar != null && eVar.getParent() == this.mSubControllerParent) {
            this.mActivatedControllers.remove(eVar);
            if (eVar.isActive()) {
                eVar.gotoDeactive();
            } else if (!$assertionsDisabled && !this.mActive) {
                throw new AssertionError();
            }
        }
    }

    public final boolean containsDirectly(e eVar) {
        if (eVar.getParent() == this.mSubControllerParent) {
            return true;
        }
        return false;
    }

    public final boolean contains(e eVar) {
        if (containsDirectly(eVar)) {
            return true;
        }
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            if (((e) it.next()).contains(eVar)) {
                return true;
            }
        }
        return false;
    }

    public final int getSubControllerCount() {
        return this.mSubControllers.size();
    }

    public final e[] getSubControllers() {
        return (e[]) this.mSubControllers.toArray(new e[0]);
    }

    public final e getSubController(int i) {
        return (e) this.mSubControllers.get(i);
    }

    public final boolean addSubController(e eVar) {
        if (this.mSubControllers.contains(eVar)) {
            return false;
        }
        this.mSubControllers.add(eVar);
        eVar.setParent(this.mSubControllerParent);
        return true;
    }

    public final boolean removeSubController(e eVar) {
        if (!this.mSubControllers.contains(eVar)) {
            return false;
        }
        deactivate(eVar);
        this.mSubControllers.remove(eVar);
        eVar.setParent(null);
        return true;
    }

    public final e findSubController(View view) {
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            if (eVar.getContentView() == view) {
                return eVar;
            }
        }
        return null;
    }

    public final View inflate(int i, ViewGroup viewGroup) {
        return LayoutInflater.from(getContext()).inflate(i, viewGroup);
    }

    public final View inflate(int i, ViewGroup viewGroup, boolean z) {
        return LayoutInflater.from(getContext()).inflate(i, viewGroup, z);
    }

    public final View findViewById(int i) {
        View view = null;
        if (this.mContentView != null) {
            view = this.mContentView.findViewById(i);
        }
        if (view == null) {
            return getActivity().findViewById(i);
        }
        return view;
    }

    public final Drawable getDrawable(int i) {
        return getResources().getDrawable(i);
    }

    public final String getString(int i) {
        return getResources().getString(i);
    }

    public final String formatString(int i, Object... objArr) {
        return formatString(getString(i), objArr);
    }

    public final String formatString(String str, Object... objArr) {
        return String.format(str, objArr);
    }

    protected final void onActivityTrimMemory(Activity activity, int i) {
        if (activity == getActivity()) {
            dispatchTrimMemory(i);
        }
    }

    protected final void onActivityResult(Activity activity, int i, int i2, Intent intent) {
        if (activity == getActivity()) {
            dispatchActivityResult(i, i2, intent);
        }
    }

    protected final void onActivityConfigurationChanged(Activity activity, Configuration configuration) {
        if (activity == getActivity()) {
            dispatchActivityConfigurationChanged(configuration);
        }
    }

    protected final void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity == getActivity()) {
            dispatchActivityCreated(bundle);
        }
    }

    protected final void onActivityPaused(Activity activity) {
        if (activity == getActivity()) {
            dispatchActivityPaused();
            gotoDeactive();
        }
    }

    protected final void onActivityResumed(Activity activity) {
        if (activity == getActivity()) {
            dispatchActivityResumed();
            gotoActive();
        }
    }

    protected final void onActivityDestroyed(Activity activity) {
        if (activity == getActivity()) {
            dispatchActivityDestroyed();
        }
    }

    protected final void onActivityWindowFocusChanged(Activity activity, boolean z) {
        if (activity == getActivity()) {
            dispatchWindowFocusChanged(z);
        }
    }

    protected final boolean onActivityBackPressed(Activity activity) {
        if (activity == getActivity() && isActive()) {
            return doBack();
        }
        return false;
    }

    protected final boolean onActivityKeyDown(Activity activity, int i, KeyEvent keyEvent) {
        if (activity == getActivity() && isActive()) {
            return dispatchKeyDown(i, keyEvent);
        }
        return false;
    }

    protected final boolean onActivityKeyUp(Activity activity, int i, KeyEvent keyEvent) {
        if (activity == getActivity() && isActive()) {
            return dispatchKeyUp(i, keyEvent);
        }
        return false;
    }

    protected final boolean onActivityShowMenu() {
        return doShowMenu();
    }

    protected final boolean onActivityHideMenu() {
        if (isMenuShowing()) {
            return doHideMenu();
        }
        return false;
    }

    protected void onActive(boolean z) {
    }

    protected void onDeactive() {
    }

    protected boolean onCheckMenuShowing() {
        return true;
    }

    protected boolean onShowMenu() {
        return false;
    }

    protected boolean onHideMenu() {
        return false;
    }

    protected boolean onPreviewBack() {
        return false;
    }

    protected boolean onBack() {
        if (!isMenuShowing()) {
            return false;
        }
        doHideMenu();
        return true;
    }

    protected boolean onRequestDetach(e eVar) {
        return requestDetach();
    }

    protected void onAttachToStub() {
    }

    protected void onDetachFromStub() {
    }

    protected void onTrimMemory(int i) {
    }

    protected void onWindowFocusChanged(boolean z) {
    }

    protected boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    protected boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    protected void onActivityCreated(Bundle bundle) {
    }

    protected void onActivityPaused() {
    }

    protected void onActivityResumed() {
    }

    protected void onActivityDestroyed() {
    }

    protected void onActivitySaveInstanceState(Bundle bundle) {
    }

    protected void onActivityConfigurationChanged(Configuration configuration) {
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
    }

    protected h newSubControllerParent() {
        return new f(this);
    }

    private final e menuShownController() {
        return this.mMenuShownRef != null ? (e) this.mMenuShownRef.get() : null;
    }

    private final void gotoActive() {
        if ($assertionsDisabled || !this.mActive) {
            this.mActive = true;
            onActive(this.mFirstActive);
            this.mFirstActive = false;
            Iterator it = this.mActivatedControllers.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (!eVar.isActive()) {
                    eVar.gotoActive();
                }
            }
            this.mDelayedRunnableQueue.a();
            return;
        }
        throw new AssertionError();
    }

    private final void gotoDeactive() {
        if ($assertionsDisabled || this.mActive) {
            ListIterator listIterator = this.mActivatedControllers.listIterator(this.mActivatedControllers.size());
            while (listIterator.hasPrevious()) {
                ((e) listIterator.previous()).gotoDeactive();
            }
            this.mActive = false;
            onDeactive();
            return;
        }
        throw new AssertionError();
    }

    private final void dispatchAttachToStub() {
        onAttachToStub();
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchAttachToStub();
        }
    }

    private final void dispatchDetachFromStub() {
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchDetachFromStub();
        }
        if (this.mRunBeforeDetach != null) {
            this.mRunBeforeDetach.run();
        }
        onDetachFromStub();
    }

    private final void dispatchTrimMemory(int i) {
        onTrimMemory(i);
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchTrimMemory(i);
        }
    }

    private final void dispatchActivityResult(int i, int i2, Intent intent) {
        onActivityResult(i, i2, intent);
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityResult(i, i2, intent);
        }
    }

    private final void dispatchActivityConfigurationChanged(Configuration configuration) {
        onActivityConfigurationChanged(configuration);
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityConfigurationChanged(configuration);
        }
    }

    private final void dispatchActivityCreated(Bundle bundle) {
        onActivityCreated(bundle);
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityCreated(bundle);
        }
    }

    private final void dispatchActivityPaused() {
        onActivityPaused();
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityPaused();
        }
    }

    private final void dispatchActivityResumed() {
        onActivityResumed();
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityResumed();
        }
    }

    private final void dispatchActivityDestroyed() {
        onActivityDestroyed();
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchActivityDestroyed();
        }
    }

    private final void dispatchWindowFocusChanged(boolean z) {
        onWindowFocusChanged(z);
        Iterator it = this.mSubControllers.iterator();
        while (it.hasNext()) {
            ((e) it.next()).dispatchWindowFocusChanged(z);
        }
    }

    protected final boolean dispatchKeyDown(int i, KeyEvent keyEvent) {
        if (i == 82) {
            return true;
        }
        ListIterator listIterator = this.mActivatedControllers.listIterator(this.mActivatedControllers.size());
        while (listIterator.hasPrevious()) {
            if (((e) listIterator.previous()).dispatchKeyDown(i, keyEvent)) {
                return true;
            }
        }
        return onKeyDown(i, keyEvent);
    }

    protected final boolean dispatchKeyUp(int i, KeyEvent keyEvent) {
        if (i != 82) {
            ListIterator listIterator = this.mActivatedControllers.listIterator(this.mActivatedControllers.size());
            while (listIterator.hasPrevious()) {
                if (((e) listIterator.previous()).dispatchKeyUp(i, keyEvent)) {
                    return true;
                }
            }
            return onKeyUp(i, keyEvent);
        } else if (isMenuShowing()) {
            return doHideMenu();
        } else {
            return doShowMenu();
        }
    }

    private final boolean doShowMenu() {
        if (isMenuShowing()) {
            return true;
        }
        ListIterator listIterator = this.mActivatedControllers.listIterator(this.mActivatedControllers.size());
        while (listIterator.hasPrevious()) {
            e eVar = (e) listIterator.previous();
            if (eVar.doShowMenu()) {
                this.mMenuShownRef = new WeakReference(eVar);
                return true;
            }
        }
        if (!onShowMenu()) {
            return false;
        }
        this.mMenuShownRef = new WeakReference(this);
        return true;
    }

    private final boolean doHideMenu() {
        e menuShownController = menuShownController();
        if (menuShownController != this) {
            return menuShownController.doHideMenu();
        }
        return onHideMenu();
    }

    private final boolean doBack() {
        if (onPreviewBack()) {
            return true;
        }
        ListIterator listIterator = this.mActivatedControllers.listIterator(this.mActivatedControllers.size());
        while (listIterator.hasPrevious()) {
            if (((e) listIterator.previous()).doBack()) {
                return true;
            }
        }
        return onBack();
    }
}