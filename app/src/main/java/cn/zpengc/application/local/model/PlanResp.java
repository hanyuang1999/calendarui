package cn.zpengc.application.local.model;

import java.util.List;


public class PlanResp {

    private String msg = "";

    private List<Plan> data;

    @Override
    public String toString() {
        return "PlanResp{" +
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

    public List<Plan> getData() {
        return data;
    }

    public void setData(List<Plan> data) {
        this.data = data;
    }
}
