package com.hillavas.toolbox.manager.rest;


import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;

public interface RestManager {

    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList();

    Single<Response<BaseModel<List<ItemHomeList>>>> getChildList(int catId);

    Single<Response<BaseModel>> getBase();



//    single<Response<BaseModel<List<ItemHomeList>,Object>>> getHomeList();




}
