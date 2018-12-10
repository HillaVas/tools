package com.newamlak.intel.objectboxtest.base;


import com.newamlak.intel.objectboxtest.manager.db.DBManager;
import com.newamlak.intel.objectboxtest.manager.pref.PrefManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BaseInteractor {

    @Inject
    protected DBManager mDBManager;
    @Inject
    protected PrefManager mPrefManager;
//    @Inject
//    protected RestManager mRestManager;
//    @Inject
//    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mCompositeDisposable;

    public void onClear() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
    }

}
