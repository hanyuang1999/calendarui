package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class AddCategoryReq {

    @SerializedName("name")
    String name;

    @SerializedName("desc")
    String desc;

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
