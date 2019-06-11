package com.hillavas.toolbox.manager.rest;

import com.hillavas.toolbox.app.network.ToolBoxApi;
import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.Response;

@SuppressWarnings("WeakerAccess")
@Singleton
public final class AppRestManager implements RestManager{

    @Inject
    ToolBoxApi mApi;

    @Inject
    public AppRestManager(){}

    @Override
    public Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList() {
        return mApi.getHomeList(1);
    }

    @Override
    public Single<Response<BaseModel<List<ItemHomeList>>>> getChildList(int catId) {
        return mApi.getChildList(1,catId);
//        return mApi.getHomeList("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f",1);
    }

    @Override
    public Single<Response<BaseModel>> getBase() {
        return mApi.getBase();
    }

}
