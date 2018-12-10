package com.newamlak.intel.objectboxtest.base;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.newamlak.intel.objectboxtest.livedata.SingleLiveData;
import com.newamlak.intel.objectboxtest.rxutils.SchedulersFacade;

import io.reactivex.disposables.CompositeDisposable;

public class BaseViewModel<S extends BaseViewState> extends ViewModel {

    protected final CompositeDisposable mCompositeDisposable;
    protected final SchedulersFacade mSchedulersFacade;
    protected final SingleLiveData<Integer> mToastLiveData;
    protected final MutableLiveData<S> mStateLD;


    public BaseViewModel(@NonNull CompositeDisposable compositeDisposable,
                         @NonNull SchedulersFacade schedulersFacade) {
        this.mCompositeDisposable = compositeDisposable;
        this.mSchedulersFacade = schedulersFacade;
        this.mToastLiveData = new SingleLiveData<>();
        this.mStateLD = new MutableLiveData<>();
    }

    public SingleLiveData<Integer> getToastLiveData() {
        return mToastLiveData;
    }

    public MutableLiveData<S> getStateLD() {
        return mStateLD;
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        mCompositeDisposable.clear();
        super.onCleared();
    }
}
