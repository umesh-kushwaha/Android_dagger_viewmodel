package com.sample.common.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Umesh on 27-02-2018.
 */

public class RefreshTokenResponse {


    //some common api error response
    @SerializedName("detail")
    @Expose
    private String detail;

    @SerializedName("message")
    @Expose
    private String message;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
