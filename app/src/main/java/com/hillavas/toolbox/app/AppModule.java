package com.hillavas.toolbox.app;

import com.hillavas.toolbox.app.network.NetworkModule;
import com.hillavas.toolbox.app.pref.SharedPrefModule;
import com.hillavas.toolbox.manager.pref.AppPrefManager;
import com.hillavas.toolbox.manager.pref.PrefManager;
import com.hillavas.toolbox.manager.rest.AppRestManager;
import com.hillavas.toolbox.manager.rest.RestManager;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module(includes = {NetworkModule.class, SharedPrefModule.class})
abstract class AppModule {

//
//    @Binds
//    @Singleton
//    abstract DBManager provideDBManager(AppDbManager dbManager);

    @Binds
    @Singleton
    abstract PrefManager providePrefManager(AppPrefManager prefManager);

    @Binds
    @Singleton
    abstract RestManager provideRestManager(AppRestManager prefManager);



    @Provides
    static CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

}
