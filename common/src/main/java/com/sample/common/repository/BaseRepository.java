package com.sample.common.repository;

import android.content.SharedPreferences;

import com.sample.common.network.CommonApiService;

/**
 * Created by Umesh on 17-03-2018.
 */

public class BaseRepository {
    protected final CommonApiService commonApiService;
    protected final SharedPreferences sharedPreferences;

    public BaseRepository(CommonApiService commonApiService, SharedPreferences sharedPreferences) {
        this.commonApiService = commonApiService;
        this.sharedPreferences = sharedPreferences;
    }
}
