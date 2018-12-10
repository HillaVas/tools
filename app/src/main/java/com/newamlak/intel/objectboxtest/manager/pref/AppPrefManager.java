package com.newamlak.intel.objectboxtest.manager.pref;

import com.f2prateek.rx.preferences2.RxSharedPreferences;

import javax.inject.Inject;

public final class AppPrefManager implements PrefManager {

    @Inject
    RxSharedPreferences mRxPref;

    @Inject
    AppPrefManager() {
    }
}
