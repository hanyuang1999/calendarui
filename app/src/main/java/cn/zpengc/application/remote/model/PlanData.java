package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanData {

    @SerializedName("Count")
    private int count;

    @SerializedName("Data")
    private List<Plan> data;

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

    public List<Plan> getData() {
        return data;
    }
}
