package com.hillavas.toolbox.base;

import android.content.Context;


import com.hillavas.toolbox.app.App;

import org.greenrobot.eventbus.EventBus;

public class ActivityLife {

    public static void register(Context context){
        App app  = ((App) context.getApplicationContext());
        app.setMainRegistered(true);

        EventBus.getDefault().register(context);
    }

    public static void unRegister(Context context){
        App app  = ((App) context.getApplicationContext());
        app.setMainRegistered(false);

        EventBus.getDefault().unregister(context);
    }
}
