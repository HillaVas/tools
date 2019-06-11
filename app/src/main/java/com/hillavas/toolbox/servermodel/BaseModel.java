package com.hillavas.toolbox.servermodel;

import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.lang.reflect.Type;

@AutoValue
public abstract class BaseModel<T> {

    @Json(name="IsSuccessful")
    public abstract boolean IsSuccessful();

    @Nullable
    @Json(name="Message")
    public abstract String Message();

    @Json(name="Result")
    public abstract T Result();


    public static <V> BaseModel<V> createBase(boolean IsSuccessful, String Message, V Result){
        return new AutoValue_BaseModel<>(IsSuccessful, Message, Result);
    }

    public static <T> JsonAdapter<BaseModel<T>> jsonAdapter(Moshi moshi, Type[] types) {
        return new AutoValue_BaseModel.MoshiJsonAdapter<>(moshi, types);
    }
}
