package com.hillavas.toolbox.activity.content;

import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.base.BaseInteractor;

import javax.inject.Inject;

import io.reactivex.Single;

public class ContentTipActivityInteractor extends BaseInteractor {

    private ContentTipActivityState mState ;

    @Inject
    ContentTipActivityInteractor(){}

    public Single<ContentTipActivityState> getContentTip(int catId) {
        return mRestManager.getContentTip(catId,"2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return ContentTipActivityState.createSuccessState(baseModelResponse.body().Result());
                    }

                    return ContentTipActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return ContentTipActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == ContentTipActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }

    public Single<ContentTipActivityState> getContentTipLike(int conId) {
        return mRestManager.getContentLike(conId,"2e8dfb86-92b2-4e43-9209-6f299cc4ef2f")
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return ContentTipActivityState.createSuccessState(baseModelResponse.body());
                    }

                    return ContentTipActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return ContentTipActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == ContentTipActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }


}
