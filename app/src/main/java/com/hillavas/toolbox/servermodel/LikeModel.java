package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.lang.reflect.Type;

@AutoValue
public abstract class LikeModel implements Parcelable {

    @Json(name="IsSuccessful")
    public abstract boolean IsSuccessful();

    @Nullable
    @Json(name="Message")
    public abstract String Message();

    @Json(name="Result")
    public abstract boolean Result();


    public static  JsonAdapter<LikeModel> jsonAdapter(Moshi moshi) {
        return new AutoValue_LikeModel.MoshiJsonAdapter(moshi);
    }

}
