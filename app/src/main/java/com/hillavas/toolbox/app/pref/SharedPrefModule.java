package com.hillavas.toolbox.app.pref;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.f2prateek.rx.preferences2.RxSharedPreferences;
import com.hillavas.toolbox.app.App;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefModule {

    @Provides
    static SharedPreferences provideSharedPrefs(App context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    static RxSharedPreferences provideRXPreference(SharedPreferences preferences){
        return RxSharedPreferences.create(preferences);
    }
}
