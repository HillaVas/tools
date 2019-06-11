package com.hillavas.toolbox.app.db;

import com.hillavas.toolbox.app.App;
import com.hillavas.toolbox.dbModel.MyObjectBox;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.objectbox.BoxStore;

@Module
public class DataBaseModule {

    @Provides
    @Singleton
    static BoxStore provideBoxStore(App app){
        return MyObjectBox.builder().androidContext(app).build();
    }
}
