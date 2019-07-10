package com.hillavas.toolbox.app.network;

import com.hillavas.toolbox.servermodel.BaseModel;
import com.hillavas.toolbox.servermodel.EarthquakeItem;
import com.hillavas.toolbox.servermodel.ItemContentList;
import com.hillavas.toolbox.servermodel.ItemHomeList;
import com.hillavas.toolbox.servermodel.SettingModel;

import java.util.List;

import javax.annotation.Nullable;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

@SuppressWarnings("WeakerAccess")
public interface ToolBoxApi {

    @GET("toolbox/api/category/get_v1")
    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList(@Header("Token") String token, @Query("pageNumber") int page);


    @GET("toolbox/api/category/get_v1")
    Single<Response<BaseModel<List<ItemHomeList>>>> getChildList(@Header("Token") String token, @Query("pageNumber") int page,@Query("categoryId") int CategoryId );



    @GET("toolbox/api/content/get")
    Single<Response<BaseModel<List<ItemContentList>>>> getContentTip(@Header("Token") String token, @Query("pageNumber") int page, @Query("categoryId") int CategoryId );

    @GET("toolbox/api/content/GetEarthquakeInfo")
    Single<Response<BaseModel<List<EarthquakeItem>>>> getEarthquakeList(@Header("Token") String token, @Query("pageNumber") int page);

//    @GET("toolbox/api/content/get?page={pageNumber}&id={id}")
//    Single<Response<BaseModel<List<ItemContentList>>>> getContentTip(@Header("Token") String token, @Path("pageNumber") int page, @Path("id") int CategoryId );

//
//    @GET("api/v1/users/leaderboard/{page}")
//    Single<Response<BaseModel<List<List<LeaderBoardUserModel>>, LeaderBoardExtra>>> getLeaderBoard(@Header("Authorization") String authorization, @Path("page") int page);

    @GET("toolbox/api")
    Single<Response<BaseModel>> getBase( );


    @GET("toolbox/api/setting/get")
    Single<Response<BaseModel<SettingModel>>> getSetting(@Header("Token") String token );



//    @GET("/category/get_v1")
//    Single<Response<BaseModel<List<ItemHomeList>>>> getHomeList(@Header("Token") String token, @Query("pageNumber") int page);
}
