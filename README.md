# todo

## 开发

main分支是最终的项目分支，请勿在main分支下开发，在自己创建的分支下开发，确认后mr到main分支

git checkout -b xxx     // 创建你自己的分支
git checkout xxx        // 跳转到你自己的分支，进行开发

git add
git commit -m ""
git push -u origin xxx     // 推送到你自己的分支



## 依赖

- room
- gson
- Retrofit
- converter-gso



## 数据结构

plan表

| 字段     | java类型     | 解释                       |
| -------- | -------- | -------------------------- |
| id       | int      | 主键                       |
| name     | String   | 名称                       |
| desc     | String   | 描述                       |
| category | String | 所属类别                   |
| state    | int      | 状态，0-未完成，1-已完成   |
| ctime    | Date     | 创建时间时间戳                   |
| mtime    | Date     | 修改时间时间戳                   |
| deadline     | String     | 截至日期    |
| deleted  | int      | soft deleted，0-未删除，1-删除 |



category表

| 字段    | java数据类型 | 解释                             |
| ------- | ------------ | -------------------------------- |
| id      | int          | 主键id                           |
| name    | String       | 类别名称                         |
| desc    | String       | 描述                             |
| ctime   | Date         | 创建时间时间戳                         |
| mtime   | Date         | 修改时间时间戳                         |
| deleted | int          | soft deleted，0-未删除，1-已删除 |



## 本地

采用room存储

例子代码 在 src/main/java/cn/zpengc/application/MainActivity.java

```java

```



接口见 src/main/java/cn/zpengc/application/local/service/TodoService.java



## 远程

先启动http服务器，接受http请求，增删改查，修改database



## 测试 & exmaple

plan测试          src/test/java/cn/zpengc/application/PlanTest.java)
category测试      src/test/java/cn/zpengc/application/CategoryTest.java)



### plan测试

按照筛选条件查询plan

筛选条件有主键id，name，deadline，state，category，如果不需要某个筛选条件，就设置该类型的零值，字符串类型零值就是就是""，int类型零之值就是0

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PlanService service = retrofit.create(PlanService.class);
//        Call<PlanListRes> listCall = service.planList("", 0, 0, "", "");  // 查询所有
//        Call<PlanListRes> listCall = service.planList("", 1, 0, "");  // 查询id是1的
        Call<PlanListRes> listCall = service.planList("", 1, 0, "", "2022-06-07");  // 查询截至日期是2022-06-07 且 id是1的
        try {
            Response<PlanListRes> res = listCall.execute();
            System.out.println(res.body());  // 返回结果集
        } catch (IOException e) {
            e.printStackTrace();
        }
```



失败添加plan情况，因为缺少必须字段，解析ToDoRes，获得提示的错误信息

```java
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
            System.out.println(res.body());  // UI解析ToDoRes获得code，message，data
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
```



成功添加plan

```java
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
```



成功更新plan

```java
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
```



失败更新plan情况，缺少id，id是必须字段，UI必须存储查询返回的id字段，可以设置不在前端显示，但是更新时候必须带上对应的id字段

```java
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
```



### category接口测试



查询

```java
Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CategoryService service = retrofit.create(CategoryService.class);
        Call<CategoryListRes> listCall = service.categoryList(0, "");  // 查询所有category，因为name 和 desc都是零值，无效
        try {
            Response<CategoryListRes> res = listCall.execute();
            System.out.println(res.body());
        } catch (IOException e) {
            e.printStackTrace();
        }
```



修改

```java
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
```



更新

```java
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
```







## 返回结果

除了查询请求 返回 PlanList 和 CategoryList，其余请求都返回ToDoRes这个数据结构

```java
public class ToDoRes {
    int code;  // 0-成功，1-失败
    String message;  // 提示消息 
    String data;  // db数据
}
```


## 图表
见 ChartActivity.class

![](https://s1.ax1x.com/2022/05/14/O6fGeH.png)

## WorkManger
