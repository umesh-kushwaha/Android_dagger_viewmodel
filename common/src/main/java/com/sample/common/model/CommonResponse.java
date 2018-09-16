package com.sample.common.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Umesh on 16-03-2018.
 */

public class CommonResponse {

    //some common api error response
    @SerializedName("detail")
    @Expose
    private String detail;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("error_description")
    @Expose
    private String errorDescription;

    @SerializedName("error")
    @Expose
    private String error;

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

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
