package com.sample;

import android.app.Activity;
import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.sample.common.CommonModuleManager;
import com.sample.di.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Umesh on 21-01-2018.
 */

public class SampleApplication extends Application implements HasActivityInjector , Foreground.Listener{

    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    private static final String TAG = SampleApplication.class.getName();

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());
        initBuildConfig();
        AppInjector.init(this);
        CommonModuleManager.init(this);

        if (BuildConfig.DEBUG) {
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectDiskReads()
                    .detectDiskWrites()
                    .detectNetwork()
                    .penaltyLog()
                    .build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectLeakedSqlLiteObjects()
                    .detectLeakedClosableObjects()
                    .penaltyLog()
                    .penaltyDropBox()
                    .build());
        }

        Foreground.init(this);
        Foreground.get().addListener(this);
    }

    private void initBuildConfig(){

    }
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return dispatchingAndroidInjector;
    }



    @Override
    public void onBecameForeground() {
        Log.i(TAG, "onBecameForeground");
    }

    @Override
    public void onBecameBackground() {
        Log.i(TAG, "onBecameBackground");

    }

    public boolean isAppInForeground(){
        return Foreground.get().isForeground();
    }


}
