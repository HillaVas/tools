package com.hillavas.toolbox.app.network;

import android.support.annotation.StringRes;


import com.hillavas.toolbox.R;

import retrofit2.Response;

public class RetrofitErrorMessageFactory {

    public static @StringRes
    int create(Response response){
        if (response.code() == 200 && response.body() == null) {
            return R.string.error_data_receive;
        }else if (response.code() == 404){
            return R.string.error_wrong_input_data;
        }else if (response.code() == 406){
            return R.string.error_server;
        }else if (response.code() == 401) {
            return R.string.error_unAuthorized;
        }else if (response.code() == 500){
            return R.string.error_server_500;
        }else
        {
            return R.string.unknown_error;
        }
    }
}
