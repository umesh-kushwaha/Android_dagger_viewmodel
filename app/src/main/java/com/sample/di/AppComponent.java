package com.sample.di;

import android.app.Application;

import com.sample.common.di.CommonModule;
import com.sample.common.network.NetworkModule;
import com.sample.SampleApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Umesh on 06-02-2018.
 */
@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class,
        MainActivityModule.class,
        NetworkModule.class,
        CommonModule.class,

})
public interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
     void inject(SampleApplication myApplication);
}
