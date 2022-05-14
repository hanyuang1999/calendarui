package cn.zpengc.application.local.service;

import android.content.Context;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.zpengc.application.local.db.TodoDatabase;
import cn.zpengc.application.local.model.Category;
import cn.zpengc.application.local.model.CategoryResp;
import cn.zpengc.application.local.model.Plan;
import cn.zpengc.application.local.model.PlanResp;
import cn.zpengc.application.remote.model.PlanListRes;

public class TodoService{

    private TodoDatabase instance;


    public TodoService(Context context) {
        this.instance = TodoDatabase.getInstance(context);
    }

    public PlanResp addPlan(Plan plan) {
        PlanResp planResp = new PlanResp();
        if(plan.getCategory() == null || plan.getCategory().getName() == "") {
            planResp.setMsg("category must not be null");
            return planResp;
        }
        if(Utils.isEmpty(plan.getName())) {
            planResp.setMsg("name must not be null");
            return planResp;
        }
        if(Utils.isEmpty(plan.getDeadline())) {
            planResp.setMsg("deadline must not be empty");
            return planResp;
        }
        instance.planDao().insert(plan);
        return planResp;
    }

    public PlanResp getAllPlan() {
        PlanResp planResp = new PlanResp();
        List<Plan> all = instance.planDao().getAll();
        if(all == null || all.size() == 0) {
            planResp.setMsg("nothing found");
            return planResp;
        }
        planResp.setData(all);
        return planResp;
    }

    public CategoryResp getAllCategory() {
        CategoryResp categoryResp = new CategoryResp();
        List<Category> all = instance.categoryDao().getAll();
        if(all == null || all.size() == 0) {
            categoryResp.setMsg("nothing found");
            return categoryResp;
        }
        categoryResp.setData(all);
        return categoryResp;
    }

    public CategoryResp addCategory(Category category) {
        CategoryResp categoryResp = new CategoryResp();
        if(category == null || Utils.isEmpty(category.getName())) {
            categoryResp.setMsg("name must not be empty");
            return categoryResp;
        }
        instance.categoryDao().insert(category);
        return categoryResp;
    }

    public PlanResp getPlanByName(String name) {
        PlanResp planResp = new PlanResp();
        if(Utils.isEmpty(name)) {
            planResp.setMsg("name must not be empty");
            return planResp;
        }
        List<Plan> res = instance.planDao().getAllByName(name);
        if(res == null || res.size() == 0) {
            planResp.setMsg("nothing found");
            return planResp;
        }
        planResp.setData(res);
        return planResp;
    }

    public CategoryResp getCategoryByName(String name) {
        CategoryResp categoryResp = new CategoryResp();
        if(Utils.isEmpty(name)) {
            categoryResp.setMsg("name must not be empty");
            return categoryResp;
        }
        List<Category> res = instance.categoryDao().getAllByName(name);
        if(res == null || res.size() == 0) {
            categoryResp.setMsg("nothing found");
            return categoryResp;
        }
        categoryResp.setData(res);
        return categoryResp;
    }

    public PlanResp getPlanByDeadline(String deadline) {
        PlanResp planResp = new PlanResp();
        if(Utils.isEmpty(deadline)) {
            planResp.setMsg("deadline must not be null");
            return planResp;
        }
        List<Plan> res = instance.planDao().getByDate(deadline);
        if(res == null || res.size() == 0) {
            planResp.setMsg("nothing found");
            return planResp;
        }
        planResp.setData(res);
        return planResp;
    }

    public CategoryResp updateCategory(Category category) {
        CategoryResp categoryResp = new CategoryResp();
        if(category == null) {
            categoryResp.setMsg("category must not be null");
            return categoryResp;
        }
        if(category.getUid() <=0 ) {
            categoryResp.setMsg("id must not be null");
            return categoryResp;
        }
        if(Utils.isEmpty(category.getName())) {
            categoryResp.setMsg("name must not be null");
            return categoryResp;
        }
        instance.categoryDao().update(category);
        return categoryResp;
    }

    public PlanResp updatePlan(Plan plan) {
        PlanResp planResp = new PlanResp();
        if(plan == null) {
            planResp.setMsg("category must not be null");
            return planResp;
        }
        if(plan.getUid() <=0) {
            planResp.setMsg("id must not be null");
            return planResp;
        }
        if(Utils.isEmpty(plan.getName())) {
            planResp.setMsg("name must not be null");
            return planResp;
        }
        if(Utils.isEmpty(plan.getDeadline())) {
            planResp.setMsg("deadline must not be null");
            return planResp;
        }
        instance.planDao().update(plan);
        return planResp;
    }

    public PlanResp deletePlan(int id) {
        PlanResp planResp = new PlanResp();
        if (id <=0 ) {
            planResp.setMsg("id must not be null");
            return planResp;
        }
        instance.planDao().delete(id);
        return planResp;
    }

    public CategoryResp deleteCategory(int id) {
        CategoryResp categoryResp = new CategoryResp();
        if (id <=0 ) {
            categoryResp.setMsg("id must not be null");
            return categoryResp;
        }
        instance.categoryDao().delete(id);
        return categoryResp;
    }

    public List<Integer> statistics(String start, String end) {
        ArrayList<Integer> list = new ArrayList<>(2);
        String format = "([0-9]{4})-([0-9]{2})-([0-9]{2})";
        if(!start.matches(format) || !end.matches(format)) {
            return list;
        }
        int ok = 0;
        int no = 0;
        List<Plan> finish = instance.planDao().getBySate(1);
        if(finish == null) {
            ok = 0;
        }
        else {
            for (Plan plan : finish) {
                if(plan.getDeadline().compareTo(start) >= 0 && plan.getDeadline().compareTo(end) <= 0) {
                    ok++;
                }
            }
        }
        List<Plan> not_finish = instance.planDao().getBySate(0);
        if(not_finish == null) {
            no = 0;
        }
        else {
            for (Plan plan : not_finish) {
                if(plan.getDeadline().compareTo(start) >= 0 && plan.getDeadline().compareTo(end) <= 0) {
                    no++;
                }
            }
        }
        list.add(no);  // 未完成数量
        list.add(ok);  // 已完成数量
        return list;
    }


}
