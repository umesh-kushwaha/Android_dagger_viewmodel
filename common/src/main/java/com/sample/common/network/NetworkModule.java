package com.sample.common.network;

import android.content.Context;
import android.content.SharedPreferences;

import com.sample.common.utils.BuildConfigUtils;

import java.io.File;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Umesh on 13-02-2018.
 */
@Module
public class NetworkModule {

    private static final int TIMEOUT_IN_MS = 30000;
    //private static final String BASE_URL = BuildConfigUtils.getInstance().getApiBaseUrl();//"http://54.70.142.5/";
    private static final String BASE_URL = "http://192.168.1.15:8000/";

    @Provides
    @Singleton
    CookieManager provideCookieManager() {
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        CookieHandler.setDefault(cookieManager);
        return cookieManager;
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideLoggingInterceptor() {
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Provides
    @Singleton
    APIInterceptor provideApiInterceptor(SharedPreferences sharedPreferences) {
        return new APIInterceptor(sharedPreferences);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(/*CookieJar cookieJar,Cache cache,*/ HttpLoggingInterceptor loggingInterceptor,
                                                                          APIInterceptor apiInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(apiInterceptor)
                .connectTimeout(TIMEOUT_IN_MS, TimeUnit.MILLISECONDS)
                // .cookieJar(cookieJar)
                // .cache(cache)
                .build();
    }

    /*@Provides
    @Singleton
    CookieJar provideCookieJar(Context context)
    {
        return new PersistentCookieJar(new SetCookieCache(), new SharedPrefsCookiePersistor(context));
    }*/

    @Provides
    @Singleton
    Cache provideCache(Context context) {
        final int cacheSize = 5 * 1024 * 1024; // 5 MB
        File cacheDir = context.getCacheDir();
        return new Cache(cacheDir, cacheSize);
    }


    /*@Provides
    @Singleton
    RxJava2CallAdapterFactory provideRxJavaCallAdapterFactory()
    {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }*/

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfigUtils.getInstance().getApiBaseUrl())
                //.baseUrl(BASE_URL)
/*
                .addConverterFactory(ScalarsConverterFactory.create())
*/.addConverterFactory(new ToStringConverterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(new LiveDataCallAdapterFactory())
                .client(okHttpClient)
                .build();
    }
}