package com.sample.common.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sample.common.di.Injectable;
import com.sample.common.model.CommonResponse;
import com.google.gson.Gson;

/**
 * Created by Umesh on 11-02-2018.
 */

public abstract class BaseFragment extends Fragment implements BaseView, Injectable {

    private BaseActivity mBaseActivity;

    protected abstract View getView(final LayoutInflater inflater, final ViewGroup container);

    protected abstract void initView(final View view);

    protected abstract void initViewModel();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseActivity) {
            mBaseActivity = (BaseActivity) context;
        }
    }

    public static String messageFromData(String data) {
        try {
            CommonResponse commonResponse = new Gson().fromJson(data, CommonResponse.class);
            return commonResponse.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String errorMessageFromData(String data){
        try {
            CommonResponse commonResponse = new Gson().fromJson(data, CommonResponse.class);
            return commonResponse.getErrorDescription();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return getView(inflater, container);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(getView());
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViewModel();
    }

    @Override
    public void showLoading(String message) {
        if (mBaseActivity != null) {
            mBaseActivity.showLoading(message);
        }
    }

    @Override
    public void showLoading() {
        if (mBaseActivity != null) {
            mBaseActivity.showLoading();
        }
    }

    @Override
    public void hideLoading() {
        if (mBaseActivity != null) {
            mBaseActivity.hideLoading();
        }
    }

    @Override
    public void onUnknownError(String error) {
        if (mBaseActivity != null) {
            mBaseActivity.onUnknownError(error);
        }
    }

    @Override
    public void onTimeout() {
        if (mBaseActivity != null) {
            mBaseActivity.onTimeout();
        }
    }

    @Override
    public void onNetworkError() {
        if (mBaseActivity != null) {
            mBaseActivity.onNetworkError();
        }
    }

    @Override
    public boolean isNetworkConnected() {
        if (mBaseActivity != null) {
            return mBaseActivity.isNetworkConnected();
        }
        return false;
    }

    @Override
    public void onConnectionError() {
        if (mBaseActivity != null) {
            mBaseActivity.onConnectionError();
        }
    }

    public void launchLinkInBrowser(String link) {
        if (mBaseActivity != null) {
            mBaseActivity.launchLinkInBrowser(link);
        }
    }

    public void launchShareIntent() {
        if (mBaseActivity != null) {
            mBaseActivity.launchShareIntent();
        }
    }
}
