package com.hillavas.toolbox.activity.earthquake;

import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class EarthquakeActivityInteractor extends BaseInteractor {

    private EarthquakeActivityState mState ;

    @Inject
    EarthquakeActivityInteractor(){}

    public Single<EarthquakeActivityState> getEarthquakeList(int catId) {
        return mRestManager.getEarthquakeList(catId,"2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return EarthquakeActivityState.createSuccessState(baseModelResponse.body().Result());
                    }

                    return EarthquakeActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return EarthquakeActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == EarthquakeActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }


}
