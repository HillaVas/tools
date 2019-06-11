package com.hillavas.toolbox.utils;

import android.content.res.Resources;

@SuppressWarnings("unused")
public class DPConverter {
    /**
     * This method converts dp unit to equivalent pixels, depending on device density.
     *
     * @param dp A value in dp (density independent pixels) unit. Which we need to convert into pixels
     * @return A float value to represent px equivalent to dp depending on device density
     */
    public static float convertDpToPx(float dp) {
        return (int) Math.ceil(dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int convertPxToDp(float px) {
        return (int) Math.ceil(px / Resources.getSystem().getDisplayMetrics().density);
    }
}
