package com.hillavas.toolbox.servermodel;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

@AutoValue
public abstract class EarthquakeItem implements Parcelable {

    @Json(name = "DateTime")
    public abstract String DateTime();

    @Json(name = "Measure")
    public abstract String Measure();

    @Json(name = "Latitude")
    public abstract String Latitude();

    @Json(name = "Longitude")
    public abstract String Longitude();

    @Json(name = "Depth")
    public abstract String Depth();

    @Json(name = "Region")
    public abstract String Region();



    public static JsonAdapter<EarthquakeItem> jsonAdapter(Moshi moshi)
    {
        return new AutoValue_EarthquakeItem.MoshiJsonAdapter(moshi);
    }

}
