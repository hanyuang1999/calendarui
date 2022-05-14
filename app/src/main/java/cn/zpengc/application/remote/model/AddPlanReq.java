package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class AddPlanReq {

    @SerializedName("name")
    String name;

    @SerializedName("desc")
    String desc;

    @SerializedName("deadline")
    String deadline;

    @SerializedName("category")
    String category;

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
