package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class EditPlanReq {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("category")
    String category;

    @SerializedName("desc")
    String desc;

    @SerializedName("deadline")
    Date deadline;

    @SerializedName("state")
    int state;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
