package cn.zpengc.application;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import cn.zpengc.application.local.model.Category;
import cn.zpengc.application.local.model.CategoryResp;
import cn.zpengc.application.local.model.Plan;
import cn.zpengc.application.local.model.PlanResp;
import cn.zpengc.application.local.service.TodoService;

public class MainActivity extends AppCompatActivity {

    private TodoService service;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service = new TodoService(this);

        // 添加plan
        for(int i=0;i<100;i++) {
            Plan plan = new Plan();
            plan.setName("FIT5160考试");
            plan.setDeadline("2022-06-07");
            Category category = new Category();
            category.setName("考试");
            plan.setCategory(category);
            PlanResp planResp = service.addPlan(plan);
            if(i % 5 == 0) {
                plan.setState(1);
                service.addPlan(plan);
            }
            Log.w(MainActivity.class.getName(), planResp.toString());
        }

        // 根据name 查询plan
        Log.w(MainActivity.class.getName(), service.getPlanByName("FIT5160考试").toString());

        // 添加category
        Category category1 = new Category();
        category1.setName("test");
        Log.w(MainActivity.class.getName(), service.addCategory(category1).toString());

        // 根据deadline 查询 plan
        Log.w(MainActivity.class.getName(), service.getPlanByDeadline("2022-06-07").toString());

        // 查询category
        Log.w(MainActivity.class.getName(), service.getAllCategory().toString());

        // 完成plan
        Plan plan1 = new Plan();
        plan1.setUid(1);
        plan1.setState(1);  // 已完成
        Log.w(MainActivity.class.getName(), service.updatePlan(plan1).toString());

        Intent intent = new Intent(this, ChartActivity.class);
        startActivity(intent);
    }
}