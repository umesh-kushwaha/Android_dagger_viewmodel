package com.sample.common.repository;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.Observer;
import android.content.SharedPreferences;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import com.sample.common.AppExecutors;
import com.sample.common.model.RefreshTokenRequest;
import com.sample.common.network.APIConstant;
import com.sample.common.network.ApiResponse;
import com.sample.common.network.CommonApiService;
import com.sample.common.utils.Constants;
import com.sample.common.utils.Objects;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.sample.common.model.login.Oauth;

/**
 * Created by Umesh on 26-02-2018.
 * @param <RequestType>
 */

public abstract class NetworkBoundResource<RequestType> {
    private final AppExecutors appExecutors;

    private int refreshCounter = 0;
    private final MediatorLiveData<Resource<RequestType>> result = new MediatorLiveData<>();
    private boolean isResponseInList = false;

    @MainThread
    public NetworkBoundResource(AppExecutors appExecutors) {
        this.appExecutors = appExecutors;
        result.setValue(Resource.loading(null));

        fetchFromNetwork();
    }


    @MainThread
    private void setValue(Resource<RequestType> newValue) {
        if (!Objects.equals(result.getValue(), newValue)) {
            result.setValue(newValue);
        }
    }

    private void fetchFromNetwork() {
        LiveData<ApiResponse<RequestType>> apiResponse = createCall();
       result.addSource(apiResponse, new Observer<ApiResponse<RequestType>>() {
           @Override
           public void onChanged(@Nullable ApiResponse<RequestType> response) {
               result.removeSource(apiResponse);

               if (response.isSuccessful()) {

                   setValue(Resource.success(response.body));

               } else {
                   if(response.code == 401 && refreshCounter == 0 ){
                       refreshToken();
                   }else {
                       Log.i("info", "error message: " + response.body);
                       setValue(Resource.error(response.errorMessage, null));
                   }
               }
           }
       });
    }

    protected void onFetchFailed() {
    }

    public LiveData<Resource<RequestType>> asLiveData() {
        return result;
    }



    @NonNull
    @MainThread
    protected abstract LiveData<ApiResponse<RequestType>> createCall();

    protected abstract RequestType processData(RequestType item);

    protected abstract CommonApiService getCommonApiService();

    protected abstract SharedPreferences getSharedPreferences();

    private void refreshToken(){
        refreshCounter++;
        CommonApiService commonApiService = getCommonApiService();//retrofit.create(CommonApiService.class);
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest();
        Gson gson = new Gson();
        Oauth oauth = gson.fromJson(getSharedPreferences().getString(Constants.PreferenceKey.OAUTH_DETIALS,""),Oauth.class);
        refreshTokenRequest.setClientId(APIConstant.CLIENT_ID);
        refreshTokenRequest.setClientSecret(APIConstant.CLIENT_SECRET);
        refreshTokenRequest.setGrantType(APIConstant.GRANT_TYPE_REFRESH_TOKEN);
        refreshTokenRequest.setRefreshToken(oauth.getRefreshToken());

        commonApiService.refreshToken(refreshTokenRequest).enqueue(new Callback<Oauth>() {
            @Override
            public void onResponse(Call<Oauth> call, Response<Oauth> response) {
                if(response.isSuccessful() && response.body() != null){
                    getSharedPreferences().edit().putString(Constants.PreferenceKey.OAUTH_DETIALS, gson.toJson(response.body())).commit();
                    fetchFromNetwork();
                }else{
                    setValue(Resource.error("Failed to refresh token", null));
                }
            }

            @Override
            public void onFailure(Call<Oauth> response, Throwable t) {
                setValue(Resource.error(t.getMessage(), null));

            }
        });
    }

}
