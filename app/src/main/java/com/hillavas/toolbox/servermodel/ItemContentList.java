package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;



@AutoValue
public abstract class ItemContentList implements Parcelable {



    @Json(name = "ContentId")
    public abstract int ContentId();

    @Json(name = "Title")
    public abstract String Title();

    @Nullable
    @Json(name = "InternetAddress")
    public abstract String InternetAddress();

    @Nullable
    @Json(name = "Desc")
    public abstract String Desc();


    @Json(name = "OrderPriority")
    public abstract int OrderPriority();


    @Json(name = "LikeCount")
    public abstract int LikeCount();


    @Json(name = "ViewCount")
    public abstract int ViewCount();



    @Json(name = "IsLiked")
    public abstract boolean IsLiked();


    @Json(name = "Attachments")
    public abstract List<AttachmentsModel> Attachments();



//    public static AutoValue_ItemContentList createItemContentList(String Title,String InternetAddress ,String Desc,int LikeCount,int ViewCount,int OrderPriority,boolean IsLiked, List<AttachmentsModel> Attachments )
//    {
//        return new AutoValue_ItemContentList(Title,InternetAddress,Desc,LikeCount,ViewCount,OrderPriority,IsLiked,Attachments);
//    }



    public static JsonAdapter<ItemContentList> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_ItemContentList.MoshiJsonAdapter(moshi);
    }

}
