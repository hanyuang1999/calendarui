package cn.zpengc.application.remote.model;

import com.google.gson.annotations.SerializedName;

public class ToDoRes {

    @SerializedName("code")
    int code;

    @SerializedName("message")
    String message;

    @SerializedName("data")
    String data;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ToDoRes{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
