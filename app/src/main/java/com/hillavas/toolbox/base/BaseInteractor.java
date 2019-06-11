package com.hillavas.toolbox.base;


import com.hillavas.toolbox.manager.db.DBManager;
import com.hillavas.toolbox.manager.pref.PrefManager;
import com.hillavas.toolbox.manager.rest.RestManager;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class BaseInteractor {

    @Inject
    protected DBManager mDBManager;
    @Inject
    protected PrefManager mPrefManager;
    @Inject
    protected RestManager mRestManager;
    @Inject
    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mCompositeDisposable;

    public void onClear() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
    }

}
