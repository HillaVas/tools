package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class AttachmentsModel implements Parcelable {


    @Json(name = "AttachmentType")
    public abstract int AttachmentType();

    @Json(name = "RelativeAddress")
    public abstract String RelativeAddress();

    public static JsonAdapter<AttachmentsModel> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_AttachmentsModel.MoshiJsonAdapter(moshi);
    }


}
