package com.hillavas.toolbox.app.network;

import android.net.Uri;


import com.hillavas.toolbox.utils.TextUtil;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;
import timber.log.Timber;

public class RequestParamsFactory {

    public static LinkedHashMap<String, String> getParams(Request request) {
        String method = request.method();
        if (method.equalsIgnoreCase("POST")) {
            return getFormParams(request.body());
        } else {
            return getQueryParams(request.url());
        }

    }

    public static LinkedHashMap<String, String> getFormParams(RequestBody body) {
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        String bodyString = bodyToString(body);

        if (TextUtil.nonNullString(bodyString)) {
            String[] bodyParams = bodyString.split("&");
            for (int i = 0; i < bodyParams.length; i++) {
                String param = bodyParams[i];
                String[] keyValue = param.split("=");
                if (keyValue.length > 1){
                    String value = keyValue[1];
                    value = Uri.decode(value);
                    params.put(keyValue[0], value);
                }else if (keyValue.length > 0){
                    params.put(keyValue[0], "");
                }
            }
            return params;
        }else{
            return params;
        }
    }

    public static LinkedHashMap<String, String> getQueryParams(HttpUrl httpUrl) {
        LinkedHashMap<String, String> params = new LinkedHashMap<>();
        Set<String> queryKeies = httpUrl.queryParameterNames();
        for (String key : queryKeies) {
            List<String> queryValues = httpUrl.queryParameterValues(key);
            if (queryValues != null) {
                for (int i = 0; i < queryValues.size(); i++) {
                    params.put(key, queryValues.get(i));
                }
            }
        }

        return params;
    }

    private static String bodyToString(final RequestBody request){
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if(copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        }
        catch (final IOException e) {
            Timber.e(e);
            return "";
        }
    }

}
