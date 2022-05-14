package cn.zpengc.application.local.model;

import java.util.List;

public class CategoryResp {

    private String msg = "";

    private List<Category> data;

    @Override
    public String toString() {
        return "CategoryResp{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Category> getData() {
        return data;
    }

    public void setData(List<Category> data) {
        this.data = data;
    }
}
