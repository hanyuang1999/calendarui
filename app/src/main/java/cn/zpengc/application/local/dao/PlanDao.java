package cn.zpengc.application.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cn.zpengc.application.local.model.Plan;


@Dao
public interface PlanDao {

    @Query("SELECT * FROM `plan` where deleted == 0")
    List<Plan> getAll();

    @Query("select * from `plan` where name = :name and deleted == 0")
    List<Plan> getAllByName(String name);

    @Query("select * from `plan` where name like '%' || :name || '%' and deleted == 0")
    List<Plan> getAllByNameFuzzy(String name);

    @Query("select * from `plan` where deleted ==0 limit :limit offset :offset")
    List<Plan> getByPage(int offset, int limit);

    @Insert()
    void insert(Plan plan);

    @Update
    public int update(Plan plan);

    @Query("update `plan` set deleted = 1 where uid = :uid")
    public int delete(int uid);

    @Query("select * from `plan` where deleted == 0 and deadline = :date")
    public List<Plan> getByDate(String date);

    @Query("select * from `plan` where state = :state and deleted = 0")
    public List<Plan> getBySate(int state);

}
