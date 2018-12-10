package com.newamlak.intel.objectboxtest.app;

import com.newamlak.intel.objectboxtest.app.db.DataBaseModule;
import com.newamlak.intel.objectboxtest.app.pref.SharedPrefModule;
import com.newamlak.intel.objectboxtest.manager.db.AppDbManager;
import com.newamlak.intel.objectboxtest.manager.db.DBManager;
import com.newamlak.intel.objectboxtest.manager.pref.AppPrefManager;
import com.newamlak.intel.objectboxtest.manager.pref.PrefManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = { SharedPrefModule.class, DataBaseModule.class})
abstract class AppModule {


    @Binds
    @Singleton
    abstract DBManager provideDBManager(AppDbManager dbManager);

    @Binds
    @Singleton
    abstract PrefManager providePrefManager(AppPrefManager prefManager);


    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
