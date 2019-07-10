package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.util.List;

import javax.annotation.Nullable;

@AutoValue
public abstract class SettingModel implements Parcelable {


    @Json(name = "AppBgColor")
    public abstract String AppBgColor();

    @Json(name = "AppMainColor")
    public abstract String AppMainColor();

    @Nullable
    @Json(name = "Attachments")
    public abstract List<AttachmentsModel> Attachments();

    public static JsonAdapter<SettingModel> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_SettingModel.MoshiJsonAdapter(moshi);
    }


}
