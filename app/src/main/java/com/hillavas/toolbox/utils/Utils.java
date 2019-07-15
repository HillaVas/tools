package com.hillavas.toolbox.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.hillavas.toolbox.model.ViewPosition;

public class Utils {

    public static ViewPosition getUpViewPosition(View view) {

        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return ViewPosition.create(location[0], location[1] - view.getMeasuredHeight());
    }


    public static boolean isMyServiceRunning(Class<?> serviceClass, Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i("Utils Service already", "running");
                return true;
            }
        }
        Log.i("Utils Service not", "running");
        return false;
    }



    public static void setResizeImg(SimpleDraweeView simpleDraweeView, Uri uri, int width, int height) {

        ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                .setResizeOptions(new ResizeOptions(width, height))
                .build();

        simpleDraweeView.setController(
                Fresco.newDraweeControllerBuilder()
                        .setOldController(simpleDraweeView.getController())
                        .setImageRequest(request)
                        .build());

    }




}
