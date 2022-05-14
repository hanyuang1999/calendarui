package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class CategoryListRes {

    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private CategoryData Data;

    @Override
    public String toString() {
        return "PlanListRes{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", Data=" + Data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public CategoryData getData() {
        return Data;
    }
}
