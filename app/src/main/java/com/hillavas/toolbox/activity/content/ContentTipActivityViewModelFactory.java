package com.hillavas.toolbox.activity.content;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.hillavas.toolbox.base.BaseViewModelFactory;

public class ContentTipActivityViewModelFactory extends BaseViewModelFactory<ContentTipActivityState,ContentTipActivityInteractor> {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T)new ContentTipActivityViewModel(mInteractor, mDisposables, mSchedulersFacade);
    }
}
