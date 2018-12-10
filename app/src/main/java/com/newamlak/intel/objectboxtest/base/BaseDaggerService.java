package com.newamlak.intel.objectboxtest.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.LifecycleService;


import com.newamlak.intel.objectboxtest.app.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

@SuppressLint("Registered")
public abstract class BaseDaggerService<S extends BaseViewState, T extends BaseViewModel<S>> extends LifecycleService {


    @Inject
    ViewModelFactory mViewModelFactory;
    protected T mViewModel;


    @Override
    public void onCreate() {
        AndroidInjection.inject(this);
        super.onCreate();


    }

    public void createViewModel(Class<T> clazz) {
        mViewModel = mViewModelFactory.create(clazz);
    }


    public void startObserving() {
        mViewModel.getStateLD().observe(this, this::handleState);
    }

    public abstract void handleState(S state);

}
