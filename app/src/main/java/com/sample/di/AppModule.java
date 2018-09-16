package com.sample.di;


import com.sample.api.APIService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Umesh on 06-02-2018.
 */

@Module(includes = ViewModelModule.class)
public class AppModule {

    @Singleton
    @Provides
    public APIService getAPIService(Retrofit retrofit){
        return retrofit.create(APIService.class);
    }

}
