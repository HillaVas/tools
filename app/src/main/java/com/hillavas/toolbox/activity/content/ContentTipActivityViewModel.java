package com.hillavas.toolbox.activity.content;

import android.support.annotation.NonNull;

import com.hillavas.toolbox.app.network.RxRetrofitErrorConsumer;
import com.hillavas.toolbox.base.BaseViewModel;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class ContentTipActivityViewModel extends BaseViewModel<ContentTipActivityState> {

    private final ContentTipActivityInteractor mInteractor;

    @Inject
    ContentTipActivityViewModel(@NonNull ContentTipActivityInteractor interactor ,@NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        mInteractor = interactor;
    }


    public void getContentTip(int catId) {

        Disposable disposable = mInteractor.getContentTip(catId).subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(ContentTipActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    public void getContentTipLike(int conId) {

        Disposable disposable = mInteractor.getContentTipLike(conId).subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(ContentTipActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    private void showState(ContentTipActivityState state) {
        if (state.status == ContentTipActivityState.STATUS_SUCCESS) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(ContentTipActivityState.STATUS_FAILED);
        }
    }
}
