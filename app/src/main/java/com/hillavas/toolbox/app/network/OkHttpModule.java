package com.hillavas.toolbox.app.network;



import com.hillavas.toolbox.app.App;


import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

import static com.hillavas.toolbox.BuildConfig.DEBUG;
import static okhttp3.logging.HttpLoggingInterceptor.Level.BODY;
import static okhttp3.logging.HttpLoggingInterceptor.Level.NONE;

@SuppressWarnings("WeakerAccess")
@Module
public class OkHttpModule {
    private static final String CACHE_CONTROL = "Cache-Control";

    @Provides
    static Cache provideCache(App context) {
        return new Cache(new File(context.getCacheDir(), "http-cache"), 10 * 1024 * 1024);
    }

    @Provides
    static HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(message -> Timber.d(message));

//        httpLoggingInterceptor.setLevel(DEBUG ? BODY : NONE);
        httpLoggingInterceptor.setLevel( BODY );

        return httpLoggingInterceptor;
    }

    @Provides
    static Interceptor provideCacheInterceptor() {
        return chain -> {
            Response response = chain.proceed(chain.request());
            // re-write response header to force use of cache
            CacheControl cacheControl = new CacheControl.Builder()
                    .maxAge(2, TimeUnit.MINUTES)
                    .build();

            return response.newBuilder()
                    .header(CACHE_CONTROL, cacheControl.toString())
                    .build();
        };
    }

    @Provides
    @Singleton
    static OkHttpClient provideClient(Cache cache,
                                      OfflineCacheInterceptor offlineCacheInterceptor,
                                      Interceptor onlineTempCache,
                                      HttpLoggingInterceptor loggingInterceptor) {

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(120, TimeUnit.SECONDS)// Set connection timeout
                .readTimeout(120, TimeUnit.SECONDS)// Read timeout
                .writeTimeout(120, TimeUnit.SECONDS)// Write timeout
                .retryOnConnectionFailure(true) //TODO CHECK IF CORRECT

                .addInterceptor(loggingInterceptor);

        //stetho interceptor is available in debug builds only
        if (DEBUG) {
//            builder.addNetworkInterceptor(new StethoInterceptor());
        }

        return builder.build();

    }
}
