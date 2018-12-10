package com.newamlak.intel.objectboxtest.activity.mainActivity;

import android.support.annotation.NonNull;

import com.newamlak.intel.objectboxtest.base.BaseViewModel;
import com.newamlak.intel.objectboxtest.rxutils.SchedulersFacade;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.disposables.CompositeDisposable;
@Module
public class MainActivityViewModel extends BaseViewModel<MainActivityState> {


    public SchedulersFacade mSchedulersFacade;
    public CompositeDisposable mCompositeDisposable;



@Inject
    public MainActivityViewModel(@NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
    }

    private void showState(MainActivityState state) {
        if (state.status == MainActivityState.STATUS_SUCCESS ) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(MainActivityState.STATUS_FAILED);
        }
    }

}
