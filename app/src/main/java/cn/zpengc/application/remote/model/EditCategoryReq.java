package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class EditCategoryReq {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("desc")
    String desc;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
