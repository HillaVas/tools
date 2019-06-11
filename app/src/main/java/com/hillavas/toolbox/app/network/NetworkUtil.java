package com.hillavas.toolbox.app.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


class NetworkUtil {
    static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager != null) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }else {
            return true;
        }
    }
}
