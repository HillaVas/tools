package com.hillavas.toolbox.activity.listActivity;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.base.BaseInteractor;
import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ListActivityInteractor extends BaseInteractor {

    private ListActivityState mState = ListActivityState.createSuccessState(null);
    private List<ItemModel> mList = new ArrayList<>();
    private ItemHomeList hm;


    @Inject
    ListActivityInteractor() {
    }

    public Single<ListActivityState> getChildList(int catId) {
        return mRestManager.getChildList(catId)
                .map(baseModelResponse -> {
                    if (baseModelResponse.code() == 200 && baseModelResponse.body().IsSuccessful() ) {
                        return ListActivityState.createSuccessState(baseModelResponse.body().Result());
                    }

                    return ListActivityState.createFailedState();
                })
                .retry(new DefaultRetrofitRetryHandler())
                .onErrorReturn(t -> {
//                    Timber.e(t,"getting cats failed");
                    return ListActivityState.createFailedState();
                })
                .doOnSuccess(state -> {
                    if (state.status == ListActivityState.STATUS_SUCCESS) {
                        mState =null;
                    }
                });
    }







}
