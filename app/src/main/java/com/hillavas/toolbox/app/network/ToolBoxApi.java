package com.hillavas.toolbox.app.network;

import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.ItemHomeList;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Query;

@SuppressWarnings("WeakerAccess")
public interface ToolBoxApi {

    @GET("toolbox/api/category/get_v1")
    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList( @Query("pageNumber") int page);


    @GET("toolbox/api/category/get_v1")
    Single<Response<BaseModel<List<ItemHomeList>>>> getChildList( @Query("pageNumber") int page,@Query("id") int CategoryId );

     @GET("toolbox/api")
    Single<Response<BaseModel>> getBase( );


//    @GET("/category/get_v1")
//    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList(@Header("Token") String token, @Query("pageNumber") int page);
}
