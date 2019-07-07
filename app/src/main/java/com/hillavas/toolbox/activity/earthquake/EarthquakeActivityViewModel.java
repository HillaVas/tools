package com.hillavas.toolbox.activity.earthquake;

import android.support.annotation.NonNull;

import com.hillavas.toolbox.app.network.RxRetrofitErrorConsumer;
import com.hillavas.toolbox.base.BaseViewModel;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

public class EarthquakeActivityViewModel extends BaseViewModel<EarthquakeActivityState> {

    private final EarthquakeActivityInteractor mInteractor;

    @Inject
    public EarthquakeActivityViewModel(@NonNull EarthquakeActivityInteractor mInteractor,@NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        this.mInteractor = mInteractor;
    }

    public void getEarthquakeList(int catId) {

        Disposable disposable = mInteractor.getEarthquakeList(catId).subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(EarthquakeActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    private void showState(EarthquakeActivityState state) {
        if (state.status == EarthquakeActivityState.STATUS_SUCCESS) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(EarthquakeActivityState.STATUS_FAILED);
        }
    }
}
