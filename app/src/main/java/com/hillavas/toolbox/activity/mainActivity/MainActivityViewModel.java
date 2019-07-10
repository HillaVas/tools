package com.hillavas.toolbox.activity.mainActivity;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.hillavas.toolbox.app.network.RxRetrofitErrorConsumer;
import com.hillavas.toolbox.base.BaseViewModel;
import com.hillavas.toolbox.rxutils.SchedulersFacade;

import javax.inject.Inject;

import dagger.Module;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

@Module
public class MainActivityViewModel extends BaseViewModel<MainActivityState> {



    private final MainActivityInteractor mInteractor;


    @Inject
    public MainActivityViewModel(@Nullable MainActivityInteractor intractor, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        this.mInteractor = intractor;
    }


    public void getHomeList() {

        Disposable disposable = mInteractor.getHomeList().subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(MainActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    public void getBase() {

        Disposable disposable = mInteractor.getBase().subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(MainActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

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
                        showState(MainActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }

    private void showState(MainActivityState state) {
        if (state.status == MainActivityState.STATUS_SUCCESS) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(MainActivityState.STATUS_FAILED);
        }
    }




}
