package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class Plan {

    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String name;

    @SerializedName("desc")
    private String desc;

    @SerializedName("state")
    private int state;

    @SerializedName("category")
    private String category;

    @SerializedName("deadline")
    private String deadline;

    @Override
    public String toString() {
        return "Plan{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", state=" + state +
                ", category='" + category + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public int getState() {
        return state;
    }

    public String getCategory() {
        return category;
    }

    public String getDeadline() {
        return deadline;
    }
}
