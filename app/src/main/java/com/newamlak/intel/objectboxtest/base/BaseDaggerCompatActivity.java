package com.newamlak.intel.objectboxtest.base;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.widget.Toast;


import com.newamlak.intel.objectboxtest.R;
import com.newamlak.intel.objectboxtest.app.viewmodel.ViewModelFactory;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;


@SuppressLint("Registered")
public abstract class BaseDaggerCompatActivity<S extends BaseViewState, T extends BaseViewModel<S>> extends DaggerAppCompatActivity {

    @Inject
    ViewModelFactory mViewModelFactory;
    protected T mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void createViewModel(Class<T> clazz) {
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(clazz);
    }

    public void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int string) {
        if (string != 0)
            Toast.makeText(getApplicationContext(), getString(string), Toast.LENGTH_SHORT).show();
    }

    public void passDataFailFinish() {
        showToast(R.string.error_wrong_passed_data);
        finish();
    }

    public void startObserving() {
        mViewModel.getStateLD().observe(this, this::handleState);
        mViewModel.getToastLiveData().observe(this, this::showToast);
    }

    public abstract void handleState(S state);

}
