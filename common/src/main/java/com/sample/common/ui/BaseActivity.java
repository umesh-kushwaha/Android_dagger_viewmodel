package com.sample.common.ui;

import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.sample.common.model.CommonResponse;
import com.sample.common.utils.BuildConfigUtils;
import com.sample.common.utils.FragmentTransactionUtils;
import com.sample.common.utils.NetworkUtils;
import com.google.gson.Gson;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.HasSupportFragmentInjector;

/**
 * Created by Umesh on 11-02-2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView, HasSupportFragmentInjector {

    @Inject
    DispatchingAndroidInjector<Fragment> dispatchingAndroidInjector;

    protected ProgressDialog progressDialog;

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return dispatchingAndroidInjector;
    }

    protected void addFragment(Fragment fragment, int resId, boolean addToBackStack) {
        FragmentTransactionUtils.addFragment(fragment, getSupportFragmentManager(), resId, addToBackStack);
    }

    protected void replaceFragment(Fragment fragment, int resId, boolean addToBackStack) {
        FragmentTransactionUtils.replaceFragment(fragment, getSupportFragmentManager(), resId, addToBackStack);
    }

    @TargetApi(Build.VERSION_CODES.M)
    public void requestPermissionsSafely(String[] permissions, int requestCode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(permissions, requestCode);
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    public boolean hasPermission(String permission) {
        return Build.VERSION.SDK_INT < Build.VERSION_CODES.M ||
                checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
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


    @Override
    public void showLoading(String message) {
        progressDialog = DialogUtils.showLoading(this, message);
    }

    @Override
    public void showLoading() {
        progressDialog = DialogUtils.showLoading(this);

    }

    @Override
    public void hideLoading() {
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.cancel();
        }
        progressDialog = null;
    }

    @Override
    public void onUnknownError(String error) {
        hideLoading();
    }

    @Override
    public void onTimeout() {
        hideLoading();
    }

    @Override
    public void onNetworkError() {
        hideLoading();
    }

    @Override
    public boolean isNetworkConnected() {
        return NetworkUtils.isConnectedToInternet(this);
    }

    @Override
    public void onConnectionError() {
        //show connection error
    }

    public void launchLinkInBrowser(String link){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
        startActivity(browserIntent);
    }

    public void launchShareIntent(){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out Retailersbook app at: https://play.google.com/store/apps/details?id="+ BuildConfigUtils.getInstance().getApplicationId()
        );
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }
}
