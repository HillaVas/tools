package com.hillavas.toolbox.activity.listActivity;

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
public class ListActivityViewModel extends BaseViewModel<ListActivityState> {




//    public SchedulersFacade mSchedulersFacade;
//    public CompositeDisposable mCompositeDisposable;
    private final ListActivityInteractor mInteractor;


    @Inject
    public ListActivityViewModel(@Nullable ListActivityInteractor interactor, @NonNull CompositeDisposable compositeDisposable, @NonNull SchedulersFacade schedulersFacade) {
        super(compositeDisposable, schedulersFacade);
        this.mInteractor = interactor;
    }


    public void getChildList(int catId) {

        Disposable disposable = mInteractor.getChildList(catId).subscribe(state ->

                {
                    Timber.d("explore state received: %s", state.toString());
                    showState(state);

                }
                , new RxRetrofitErrorConsumer() {
                    @Override
                    public void handleError(Throwable throwable, int id) {
                        Timber.e(throwable, "receiving explore state failed");
                        showState(ListActivityState.createFailedState());

                    }
                });

        mCompositeDisposable.add(disposable);

    }


    private void showState(ListActivityState state) {
        if (state.status == ListActivityState.STATUS_SUCCESS) {
            mStateLD.postValue(state);
        } else {
            mToastLiveData.postValue(ListActivityState.STATUS_FAILED);
        }
    }









}
