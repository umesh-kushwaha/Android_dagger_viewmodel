package com.sample.common.ui;

/**
 * Created by Umesh on 11-02-2018.
 */

public interface BaseView {
    void showLoading(String message);

    void showLoading();

    void hideLoading();

    void onUnknownError(String error);

    void onTimeout();

    void onNetworkError();

    boolean isNetworkConnected();

    void onConnectionError();
}
