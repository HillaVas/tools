package com.hillavas.toolbox.app;



import android.app.Activity;

import com.hillavas.toolbox.manager.pref.PrefManager;
import com.hillavas.toolbox.manager.rest.RestManager;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import dagger.android.DispatchingAndroidInjector;

public class App extends DaggerApplication {

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;
    @Inject
    RestManager mRestManager;
    @Inject
    PrefManager mPrefManager;
    @Inject
    SchedulersFacade mSchedulersFacade;
//    @Inject
//    OneSignalNotificationHandler mOneSignalNotificationHandler;

    private boolean mainRegistered = false;

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().create(this);
    }

    public boolean isMainRegistered() {
        return mainRegistered;
    }

    public void setMainRegistered(boolean mainRegistered) {
        this.mainRegistered = mainRegistered;
    }
}
