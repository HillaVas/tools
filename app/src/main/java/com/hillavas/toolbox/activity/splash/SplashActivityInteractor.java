package com.hillavas.toolbox.activity.splash;

import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class SplashActivityInteractor extends BaseInteractor {

    private SplashActivityState mState = SplashActivityState.createSuccessState(null);

    @Inject
    SplashActivityInteractor() {
    }


    public Single<SplashActivityState> getSetting() {
        return mRestManager.getSetting("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return SplashActivityState.createSuccessState(baseModelResponse.body().Result());
                    }

                    return SplashActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return SplashActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == SplashActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }

}
