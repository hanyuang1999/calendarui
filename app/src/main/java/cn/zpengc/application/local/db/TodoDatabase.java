package cn.zpengc.application.local.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import cn.zpengc.application.local.dao.CategoryDao;
import cn.zpengc.application.local.dao.PlanDao;
import cn.zpengc.application.local.model.Category;
import cn.zpengc.application.local.model.Plan;
import cn.zpengc.application.local.service.Converters;


@Database(version = 1, entities = {Category.class, Plan.class}, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase instance;

    public abstract CategoryDao categoryDao();

    public abstract PlanDao planDao();

    public static TodoDatabase getInstance(Context context) {
        if(instance == null) {
            synchronized (TodoDatabase.class) {
                if(instance == null) {
                    return Room.databaseBuilder(context.getApplicationContext(),
                            TodoDatabase.class, "todo database").allowMainThreadQueries().build();
                }
            }
        }
        return instance;
    }
}
