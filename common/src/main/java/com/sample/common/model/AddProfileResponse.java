package com.sample.common.model;

/**
 * Created by mdnafiskhan on 01/05/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddProfileResponse extends CommonResponse{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("shop_id")
    @Expose
    private Integer shopId;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("is_admin")
    @Expose
    private Boolean isAdmin;
    @SerializedName("group")
    @Expose
    private Integer group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public AddProfileResponse withId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public AddProfileResponse withShopId(Integer shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public AddProfileResponse withType(String type) {
        this.type = type;
        return this;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public AddProfileResponse withIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
        return this;
    }

    public Integer getGroup() {
        return group;
    }

    public void setGroup(Integer group) {
        this.group = group;
    }

    public AddProfileResponse withGroup(Integer group) {
        this.group = group;
        return this;
    }

}