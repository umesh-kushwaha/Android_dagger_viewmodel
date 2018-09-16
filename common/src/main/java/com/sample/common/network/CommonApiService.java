package com.sample.common.network;

import com.sample.common.model.RefreshTokenRequest;
import com.sample.common.model.login.Oauth;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by Umesh on 16-03-2018.
 */

public interface CommonApiService {

    @POST("user/refresh_token/")
    Call<Oauth> refreshToken(@Body RefreshTokenRequest refreshTokenRequest);
}
