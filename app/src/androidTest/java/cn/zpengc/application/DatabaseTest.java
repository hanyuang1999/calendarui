package cn.zpengc.application;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import cn.zpengc.application.local.dao.CategoryDao;
import cn.zpengc.application.local.dao.PlanDao;
import cn.zpengc.application.local.db.TodoDatabase;
import cn.zpengc.application.local.model.Category;
import cn.zpengc.application.local.model.Plan;
import cn.zpengc.application.local.service.TodoService;

@RunWith(AndroidJUnit4.class)
public class DatabaseTest {

    private CategoryDao categoryDao;
    private PlanDao planDao;
    private TodoDatabase db;
    private TodoService service;

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, TodoDatabase.class).build();
        categoryDao = db.categoryDao();
        planDao = db.planDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void categoryTest() throws Exception {
        Category category = new Category();
        category.setName("work");
        categoryDao.insert(category);
        List<Category> byName = categoryDao.getAllByName("work");
        for (Category category1 : byName) {
            System.out.println(category1);
        }
    }

    @Test
    public void planTest() throws Exception {
        Plan plan = new Plan();
        plan.setUid(10);
        plan.setName("考试");
        plan.setCategory("测试");
        planDao.insert(plan);
//        service.addPlan(plan);
        List<Plan> res = planDao.getAllByName("考试");
//        PlanResp planResp = service.getPlanByName("考试");
        System.out.println(res);
    }

}
