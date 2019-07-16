package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;



@AutoValue
public abstract class ItemHomeList implements Parcelable {


    @Json(name = "CategoryId")
    public abstract int CategoryId();

    @Nullable
    @Json(name = "ContentType")
    public abstract Integer ContentType();


    @Json(name = "ShowName")
    public abstract boolean ShowName();


    @Json(name = "Name")
    public abstract String Name();


    @Json(name = "HasChild")
    public abstract boolean HasChild();

    @Nullable
    @Json(name = "Attachments")
    public abstract List<AttachmentsModel> Attachments();



//    public static AutoValue_ItemHomeList createItemHomeList(int CategoryId, Integer ContentType ,boolean ShowName,String Name,boolean HasChild, List<AttachmentsModel> Attachments )
//    {
//        return new AutoValue_ItemHomeList(CategoryId,ContentType,ShowName,Name,HasChild,Attachments);
//    }



    public static JsonAdapter<ItemHomeList> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_ItemHomeList.MoshiJsonAdapter(moshi);
    }

}
