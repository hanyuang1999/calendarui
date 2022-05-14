package cn.zpengc.application;

import org.junit.Test;

import java.io.IOException;

import cn.zpengc.application.remote.model.AddPlanReq;
import cn.zpengc.application.remote.model.EditPlanReq;
import cn.zpengc.application.remote.model.PlanListRes;
import cn.zpengc.application.remote.model.ToDoRes;
import cn.zpengc.application.remote.service.PlanService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PlanTest {

    @Test
    public void PlanList_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
//        Call<PlanListRes> listCall = service.planList("", 0, 0, "", "");  // 查询所有
//        Call<PlanListRes> listCall = service.planList("", 1, 0, "");  // 查询id是1的
        Call<PlanListRes> listCall = service.planList("", 0, 0, "", "2022-06-07");  // 查询截至日期是2022-06-07
        try {
            Response<PlanListRes> res = listCall.execute();
            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AddPlanFailed_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
        AddPlanReq addPlanReq = new AddPlanReq();
        addPlanReq.setName("test");
        addPlanReq.setCategory("test");
        Call<ToDoRes> listCall = service.addPlan(addPlanReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());  // UI解析code，message
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void AddPlanSuccess_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
        AddPlanReq addPlanReq = new AddPlanReq();
        addPlanReq.setName("test");
        addPlanReq.setCategory("test");
        addPlanReq.setDeadline("2022-10-01");
        Call<ToDoRes> listCall = service.addPlan(addPlanReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());  // UI解析code，message，data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void EditPlanSuccess_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
        EditPlanReq editPlanReq = new EditPlanReq();
        editPlanReq.setName("game");
        editPlanReq.setId(1);
        Call<ToDoRes> listCall = service.editPlan(editPlanReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());  // UI解析code，message，data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void EditPlanFail_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
        EditPlanReq editPlanReq = new EditPlanReq();
        editPlanReq.setName("game");
        Call<ToDoRes> listCall = service.editPlan(editPlanReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());  // UI解析code，message，data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
