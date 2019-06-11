package com.hillavas.toolbox.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ViewPosition implements Parcelable {

    public abstract int x();

    public abstract int y();


    public static ViewPosition create(int x, int y) {
        return new AutoValue_ViewPosition(x, y);
    }

}
