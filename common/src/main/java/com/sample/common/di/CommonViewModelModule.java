package com.sample.common.di;

import android.arch.lifecycle.ViewModelProvider;

import com.sample.common.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;

/**
 * Created by Umesh on 28-02-2018.
 */
@Module
public abstract class CommonViewModelModule {
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
