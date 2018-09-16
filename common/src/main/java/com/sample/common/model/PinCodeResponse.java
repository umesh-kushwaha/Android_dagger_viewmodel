package com.sample.common.model;

/**
 * Created by mdnafiskhan on 08/04/2018.
 */


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PinCodeResponse {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("office_name")
    @Expose
    private String officeName;
    @SerializedName("region_name")
    @Expose
    private String regionName;
    @SerializedName("circle_name")
    @Expose
    private String circleName;
    @SerializedName("division_name")
    @Expose
    private String divisionName;
    @SerializedName("district_name")
    @Expose
    private String districtName;
    @SerializedName("state_name")
    @Expose
    private String stateName;
    @SerializedName("taluk")
    @Expose
    private String taluk;
    @SerializedName("pincode")
    @Expose
    private String pincode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getCircleName() {
        return circleName;
    }

    public void setCircleName(String circleName) {
        this.circleName = circleName;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getTaluk() {
        return taluk;
    }

    public void setTaluk(String taluk) {
        this.taluk = taluk;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }


}