package com.hillavas.toolbox.fragment;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.hillavas.toolbox.base.BaseViewModelFactory;

public class HomeFragmentViewModelFactory extends BaseViewModelFactory<HomeFragmentState,HomeFragmentInteractor> {
    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;
    }
}
