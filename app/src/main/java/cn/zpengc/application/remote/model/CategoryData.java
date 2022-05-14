package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoryData {

    @SerializedName("Count")
    private int count;

    @SerializedName("Data")
    private List<Category> data;

    @Override
    public String toString() {
        return "Data{" +
                "count=" + count +
                ", data=" + data +
                '}';
    }

    public int getCount() {
        return count;
    }

    public List<Category> getData() {
        return data;
    }
}
