package com.sample.common.network;

import android.content.SharedPreferences;
import android.util.Log;

import com.sample.common.model.login.Oauth;
import com.sample.common.utils.Constants;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Umesh on 13-02-2018.
 * THis is used to intercept all request and add common token or authentication
 */

public class APIInterceptor implements Interceptor{

    SharedPreferences preferences;

    private static final String TAG = APIInterceptor.class.getName();

    public APIInterceptor(SharedPreferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {

        Log.i(TAG, " intercept API :");

        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();
       if( !(originalHttpUrl.toString().contains("login") || originalHttpUrl.toString().contains("latest/app/release") || originalHttpUrl.toString().contains("resend/otp"))){
           Log.i(TAG, " intercept API access token:" +getAccessToken());
           //add the authorization header
           Request.Builder requestBuilder = original.newBuilder()
                   .addHeader("Authorization", "Bearer " + getAccessToken());
           return chain.proceed(requestBuilder.build());
       }
        return chain.proceed(chain.request());
    }

    private String getAccessToken(){
        Gson gson = new Gson();
        Oauth oauth = gson.fromJson(preferences.getString(Constants.PreferenceKey.OAUTH_DETIALS,""), Oauth.class);
        return oauth.getAccessToken();
    }
}
