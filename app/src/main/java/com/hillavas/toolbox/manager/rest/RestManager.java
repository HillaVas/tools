package com.hillavas.toolbox.manager.rest;


import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;

public interface RestManager {

    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList(String token);

    Single<Response<BaseModel<List<ItemHomeList>>>> getChildList(int catId,String token);

    Single<Response<BaseModel<List<ItemContentList>>>> getContentTip(int catId,String token);

    Single<Response<BaseModel<List<EarthquakeItem>>>> getEarthquakeList(int catId, String token);

    Single<Response<BaseModel>> getBase();

    Single<Response<BaseModel<SettingModel>>> getSetting(String token);



//    single<Response<BaseModel<List<ItemHomeList>,Object>>> getHomeList();




}
