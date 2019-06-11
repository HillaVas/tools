package com.hillavas.toolbox.app.network;

import com.hillavas.toolbox.moshi.MoshiAdapterFactory;
import com.hillavas.toolbox.rxutils.SchedulersFacade;
import com.squareup.moshi.Moshi;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

@Module(includes = {OkHttpModule.class})
public class NetworkModule {


    @Provides
    static Moshi provideTypeAdapter() {
        return new Moshi.Builder()
                .add(MoshiAdapterFactory.create())
                .build();
    }


    @Provides
    static Retrofit provideRestHelper(OkHttpClient client, Moshi moshi, SchedulersFacade scheduler) {
        return new Retrofit.Builder()
                .baseUrl(EndPoint.getDomain())
                .client(client)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(scheduler.io()))
                .build();
    }

    @Provides
    @Singleton
    static ToolBoxApi provideApi(Retrofit retrofit) {
        return retrofit.create(ToolBoxApi.class);
    }


}
