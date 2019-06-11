package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import java.io.Serializable;
import java.lang.reflect.Type;


@AutoValue
public class HilaModel implements Serializable {

    @Json(name ="address")
    public String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Json(name = "Message")
//    public abstract String Message();
//
//    @Json(name = "Result")
//    public abstract String Result();
//
//    public static  HilaModel createBase(boolean IsSuccessful, String Message, String Result){
//        return new AutoValue_HilaModel(IsSuccessful, Message, Result);
//    }
//
//    public static  JsonAdapter<HilaModel> jsonAdapter(Moshi moshi) {
//        return new AutoValue_HilaModel.MoshiJsonAdapter(moshi);
//    }

}
