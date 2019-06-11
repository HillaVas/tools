package com.hillavas.toolbox.app.network;

import android.support.annotation.StringRes;


import com.hillavas.toolbox.R;

import java.io.InterruptedIOException;
import java.net.ConnectException;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;


public class RetrofitErrorHandler {
    @SuppressWarnings("WeakerAccess")
    public static @StringRes
    int getError(Throwable error){
        if (error instanceof TimeoutException || error instanceof InterruptedIOException)
            return R.string.error_time_out;
        else if (error instanceof ConnectException)
            return R.string.error_connection_failure;
        else if (error instanceof NoSuchElementException)
            return R.string.error_no_item_received;
        else if (error instanceof IllegalArgumentException)
            return R.string.error_data_receive;
        else
            return R.string.error_server_failure;
    }
}
