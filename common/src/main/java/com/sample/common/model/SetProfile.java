package com.sample.common.model;

/**
 * Created by umesh on 01/05/2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SetProfile {

    @SerializedName("profile_id")
    @Expose
    private Integer profileId;

    public Integer getProfileId() {
        return profileId;
    }

    public void setProfileId(Integer profileId) {
        this.profileId = profileId;
    }

    public SetProfile withProfileId(Integer profileId) {
        this.profileId = profileId;
        return this;
    }

}
