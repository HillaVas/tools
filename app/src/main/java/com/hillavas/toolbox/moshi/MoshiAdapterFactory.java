package com.hillavas.toolbox.moshi;

import com.squareup.moshi.JsonAdapter;

@com.ryanharter.auto.value.moshi.MoshiAdapterFactory
public abstract class MoshiAdapterFactory implements JsonAdapter.Factory {

//     Static factory method to access the package
//     private generated implementation
    public static JsonAdapter.Factory create() {
        return new AutoValueMoshi_MoshiAdapterFactory();
    }

}
