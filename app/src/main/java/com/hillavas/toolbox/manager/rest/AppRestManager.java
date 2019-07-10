package com.hillavas.toolbox.manager.rest;

import com.hillavas.toolbox.app.network.ToolBoxApi;
import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;

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
    public Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList(String token) {
        return mApi.getHomeList(token,1);
    }

    @Override
    public Single<Response<BaseModel<List<ItemHomeList>>>> getChildList(int catId,String token) {
        return mApi.getChildList(token,1,catId);
//        return mApi.getHomeList("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f",1);
    }

    @Override
    public Single<Response<BaseModel<List<ItemContentList>>>> getContentTip(int catId,String token) {
        return mApi.getContentTip(token,1,catId);
//        return mApi.getHomeList("2e8dfb86-92b2-4e43-9209-6f299cc4ef2f",1);
    }

    @Override
    public Single<Response<BaseModel<List<EarthquakeItem>>>> getEarthquakeList(int catId, String token) {
        return mApi.getEarthquakeList(token,1);
    }

    @Override
    public Single<Response<BaseModel>> getBase() {
        return mApi.getBase();
    }

    @Override
    public Single<Response<BaseModel<SettingModel>>> getSetting(String token) {

        return mApi.getSetting(token);
    }

}
