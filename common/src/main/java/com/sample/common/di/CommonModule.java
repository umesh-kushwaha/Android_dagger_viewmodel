package com.sample.common.di;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.sample.common.network.CommonApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Umesh on 27-02-2018.
 */

@Module(includes = {CommonViewModelModule.class})
public class CommonModule {

    private static final String PREF_NAME = "retailers_book_logistic";

    @Singleton
    @Provides
    public SharedPreferences getSharedPreferences(Application application){
        return application.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    @Singleton
    @Provides
    public CommonApiService getCommonApiService(Retrofit retrofit){
        return retrofit.create(CommonApiService.class);
    }
}
