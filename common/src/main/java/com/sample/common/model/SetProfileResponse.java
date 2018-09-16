package com.sample.common.model;

/**
 * Created by umesh on 01/05/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetProfileResponse {

    @SerializedName("message")
    @Expose
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SetProfileResponse withMessage(String message) {
        this.message = message;
        return this;
    }

}