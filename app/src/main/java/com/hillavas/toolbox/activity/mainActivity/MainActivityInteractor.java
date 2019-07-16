package com.hillavas.toolbox.activity.mainActivity;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.app.network.RetrofitErrorHandler;
import com.hillavas.toolbox.app.network.RetrofitErrorMessageFactory;
import com.hillavas.toolbox.base.BaseInteractor;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import timber.log.Timber;

public class MainActivityInteractor extends BaseInteractor {

    private MainActivityState mState = MainActivityState.createSuccessState(null);
    private ItemHomeList hm;

    @Inject
    MainActivityInteractor() {
    }


    public Single<MainActivityState> getHomeList() {
        return mRestManager.getHomeList("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return MainActivityState.createSuccessState(baseModelResponse.body().Result());
                    }

                    return MainActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return MainActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == MainActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }

    public Single<MainActivityState> getBase() {
        return mRestManager.getBase()
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return MainActivityState.createSuccessState();
                    }

                    return MainActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return MainActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == MainActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }

    public Single<MainActivityState> getSetting() {
        return mRestManager.getSetting("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return MainActivityState.createSuccessSettingState(baseModelResponse.body().Result());
                    }

                    return MainActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return MainActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == MainActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }




}
