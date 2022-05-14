package cn.zpengc.application.local.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import cn.zpengc.application.local.model.Category;


@Dao
public interface CategoryDao {

    @Query("SELECT * FROM category")
    List<Category> getAll();

    @Query("select * from category where name = :name and deleted = 0")
    List<Category> getAllByName(String name);

    @Query("select * from category where name like '%' || :name || '%' and deleted = 0")
    List<Category> getAllByNameFuzzy(String name);

    @Insert()
    void insert(Category category);

    @Update
    public int update(Category category);

    @Query("update category set deleted = 1 where uid = :uid")
    public int delete(int uid);
}
