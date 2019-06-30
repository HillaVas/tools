package com.hillavas.toolbox.activity.mainActivity;

import com.hillavas.toolbox.R;
import com.hillavas.toolbox.app.network.DefaultRetrofitRetryHandler;
import com.hillavas.toolbox.app.network.RetrofitErrorHandler;
import com.hillavas.toolbox.app.network.RetrofitErrorMessageFactory;
import com.hillavas.toolbox.base.BaseInteractor;
import com.hillavas.toolbox.dbModel.ItemModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;
import timber.log.Timber;

public class MainActivityInteractor extends BaseInteractor {

    private MainActivityState mState = MainActivityState.createSuccessState(null);
    private List<ItemModel> mList = new ArrayList<>();
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


    public List<ItemModel> createList() {


        for (int i = 0; i < 21; i++) {
            ItemModel item = new ItemModel();
            item.setId(i);
            item.setImageAddress(0);
//            item.setName(R.string.offline_item_home_list_+String.valueOf(i));
//            if (i%2==0)
//                item.setAddress("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTR8oSRnAzZ1HIWSiZbGVsKm44hR6qSOhQoW9pNzqjNNguuatnh");
//            else
                item.setAddress("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSBrScAR_J7A_O6JRsMs352_en8WQ0JYtGMQFtxGx62kHIDTyujYQ");
            mList.add(item);

        }
        mList.get(0).setName("بانک");
        mList.get(1).setName("موبایل");
        mList.get(2).setName("استخاره");
        mList.get(3).setName("املاک");
        mList.get(4).setName("مدیا");
        mList.get(5).setName("خودرو");
        mList.get(6).setName("ترافیک");
        mList.get(7).setName("فال");
        mList.get(8).setName("تعبیر خواب");
        mList.get(9).setName("تقویم");
        mList.get(10).setName("ریمایندر");
        mList.get(11).setName("ابزار");
        mList.get(12).setName("دستیار سلامت");
        mList.get(13).setName("خبر");
        mList.get(14).setName("خبر");
        mList.get(15).setName("خبر");
        mList.get(16).setName("خبر");
        mList.get(17).setName("خبر");
        mList.get(18).setName("خبر");
        mList.get(19).setName("گردش کار");
        mList.get(20).setName("برنامه های کاربردی");

//        mList.get(0).setImageAddress(R.drawable.group003);
//        mList.get(1).setImageAddress(R.drawable.group005);
//        mList.get(2).setImageAddress(R.drawable.group004);
//        mList.get(3).setImageAddress(R.drawable.group006);
//        mList.get(4).setImageAddress(R.drawable.group_1);
//        mList.get(5).setImageAddress(R.drawable.group007);
//        mList.get(6).setImageAddress(R.drawable.group008);
//        mList.get(7).setImageAddress(R.drawable.group009);
//        mList.get(8).setImageAddress(R.drawable.group0010);
//        mList.get(9).setImageAddress(R.drawable.group0011);
//        mList.get(10).setImageAddress(R.drawable.group0013);
//        mList.get(11).setImageAddress(R.drawable.group0012);
//        mList.get(12).setImageAddress(R.drawable.group_2);
//        mList.get(13).setImageAddress(R.drawable.a0015);
//        mList.get(14).setImageAddress(R.drawable.a0014);
//        mList.get(15).setImageAddress(R.drawable.a);
//        mList.get(16).setImageAddress(R.drawable.b);
//        mList.get(17).setImageAddress(R.drawable.c);
//        mList.get(18).setImageAddress(R.drawable.r);
//        mList.get(19).setImageAddress(R.drawable.d);
//        mList.get(20).setImageAddress(R.drawable.a00158);

        return mList;
    }



}
