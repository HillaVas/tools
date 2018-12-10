package com.newamlak.intel.objectboxtest.app;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;

public class App extends DaggerApplication {

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
