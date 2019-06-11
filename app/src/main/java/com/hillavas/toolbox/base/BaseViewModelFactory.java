package com.hillavas.toolbox.base;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;


import com.hillavas.toolbox.livedata.SingleLiveData;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModelFactory<S extends BaseViewState, T extends BaseInteractor> implements ViewModelProvider.Factory {

    @Inject
    protected T mInteractor;
    @Inject
    protected SchedulersFacade mSchedulersFacade;
    @Inject
    protected CompositeDisposable mDisposables;

    protected final SingleLiveData<Integer> mToastLiveData;
    protected final MutableLiveData<S> mStateLD;

    protected BaseViewModelFactory() {
        mStateLD = new MutableLiveData<>();
        mToastLiveData = new SingleLiveData<>();
    }
}
