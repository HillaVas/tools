package com.hillavas.toolbox.fragment;

import android.support.annotation.NonNull;

import com.hillavas.toolbox.base.BaseViewModel;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import io.reactivex.disposables.CompositeDisposable;

public class HomeFragmentViewModel extends BaseViewModel<HomeFragmentState> {
    public HomeFragmentViewModel(@NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
    }
}
