package cn.zpengc.application.remote.service;

import cn.zpengc.application.remote.model.AddPlanReq;
import cn.zpengc.application.remote.model.EditPlanReq;
import cn.zpengc.application.remote.model.PlanListRes;
import cn.zpengc.application.remote.model.ToDoRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface PlanService {

    @GET("/plan/list")
    Call<PlanListRes> planList(@Query("name") String name, @Query("id") int id, @Query("state") int state,
                               @Query("category") String category, @Query("name") String deadline);

    @POST("/plan/add")
    Call<ToDoRes> addPlan(@Body AddPlanReq req);

    @POST("/plan/edit")
    Call<ToDoRes> editPlan(@Body EditPlanReq req);
}
