package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class Category {

    @SerializedName("id")
    int id;

    @SerializedName("name")
    String name;

    @SerializedName("desc")
    String desc;

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
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
}
