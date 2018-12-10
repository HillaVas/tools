package com.newamlak.intel.objectboxtest.activity.itemList;

import android.support.annotation.NonNull;

import com.newamlak.intel.objectboxtest.base.BaseViewModel;
import com.newamlak.intel.objectboxtest.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class ItemListActivityViewModel extends BaseViewModel<ItemListActivityState> {

    public SchedulersFacade mSchedulersFacade;
    public CompositeDisposable mCompositeDisposable;

    @Inject
    public ItemListActivityViewModel(@NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
    }


    private void showState(ItemListActivityState state) {
        if (state.status == ItemListActivityState.STATUS_SUCCESS ) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(ItemListActivityState.STATUS_FAILED);
        }
    }
}
