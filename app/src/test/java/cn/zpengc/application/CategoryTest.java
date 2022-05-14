package cn.zpengc.application;

import org.junit.Test;

import java.io.IOException;

import cn.zpengc.application.remote.model.AddCategoryReq;
import cn.zpengc.application.remote.model.CategoryListRes;
import cn.zpengc.application.remote.model.EditCategoryReq;
import cn.zpengc.application.remote.model.ToDoRes;
import cn.zpengc.application.remote.service.CategoryService;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CategoryTest {

    @Test
    public void CategoryList_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryService service = retrofit.create(CategoryService.class);
        Call<CategoryListRes> listCall = service.categoryList(0, "");
        try {
            Response<CategoryListRes> res = listCall.execute();
            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void AddCategory_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryService service = retrofit.create(CategoryService.class);
        AddCategoryReq addCategoryReq = new AddCategoryReq();
        addCategoryReq.setName("learn");
        Call<ToDoRes> listCall = service.addCategory(addCategoryReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void EditCategory_test() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryService service = retrofit.create(CategoryService.class);
        EditCategoryReq editCategoryReq = new EditCategoryReq();
        editCategoryReq.setName("life");
        editCategoryReq.setId(1);
        Call<ToDoRes> listCall = service.editCategory(editCategoryReq);
        try {
            Response<ToDoRes> res = listCall.execute();
            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
