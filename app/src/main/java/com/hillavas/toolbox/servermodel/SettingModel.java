package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import androidx.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;



@AutoValue
public abstract class SettingModel implements Parcelable {


    @Json(name = "AppBgColor")
    public abstract String AppBgColor();

    @Json(name = "AppMainColor")
    public abstract String AppMainColor();

    @Json(name = "IsForcedUpdate")
    public abstract boolean IsForcedUpdate();

    @Nullable
    @Json(name = "AppVersion")
    public abstract String AppVersion();

    @Nullable
    @Json(name = "AppDownloadLinkUrl")
    public abstract String AppDownloadLinkUrl();

    @Nullable
    @Json(name = "Attachments")
    public abstract List<AttachmentsModel> Attachments();

    public static JsonAdapter<SettingModel> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_SettingModel.MoshiJsonAdapter(moshi);
    }

    public static SettingModel createSetting(String AppBgColor,String AppMainColor,boolean IsForcedUpdate,String AppVersion,String AppDownloadLinkUrl,List<AttachmentsModel> Attachments){
        return new AutoValue_SettingModel(AppBgColor,AppMainColor,IsForcedUpdate,AppVersion,AppDownloadLinkUrl,Attachments);
    }


}
