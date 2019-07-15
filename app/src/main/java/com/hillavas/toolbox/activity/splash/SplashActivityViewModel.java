package com.hillavas.toolbox.activity.splash;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hillavas.toolbox.app.network.RxRetrofitErrorConsumer;
import com.hillavas.toolbox.base.BaseViewModel;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class SplashActivityViewModel extends BaseViewModel <SplashActivityState>
{
    private  final SplashActivityInteractor mInteractor;

    @Inject
    public SplashActivityViewModel(@Nullable SplashActivityInteractor interactor, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        this.mInteractor = interactor;
    }

    public void getSetting() {

        Disposable disposable = mInteractor.getSetting().subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(SplashActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    private void showState(SplashActivityState state) {
        if (state.status == SplashActivityState.STATUS_SUCCESS) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(SplashActivityState.STATUS_FAILED);
        }
    }


}
