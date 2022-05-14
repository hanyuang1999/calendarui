package cn.zpengc.application.remote.service;

import cn.zpengc.application.remote.model.AddCategoryReq;
import cn.zpengc.application.remote.model.CategoryListRes;
import cn.zpengc.application.remote.model.EditCategoryReq;
import cn.zpengc.application.remote.model.ToDoRes;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CategoryService {

    @GET("/category/list")
    Call<CategoryListRes> categoryList(@Query("id") int id, @Query("name") String name);

    @POST("/category/add")
    Call<ToDoRes> addCategory(@Body AddCategoryReq req);

    @POST("/category/edit")
    Call<ToDoRes> editCategory(@Body EditCategoryReq req);

}
