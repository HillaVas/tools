package com.hillavas.toolbox.manager.pref;


import android.support.annotation.StringDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@StringDef({
        LoginConstants.LOGGED_OUT,
        LoginConstants.LOGGED_IN

})
public @interface LoginType {
}

