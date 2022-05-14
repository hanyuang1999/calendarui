package cn.zpengc.application.local.service;

import androidx.room.TypeConverter;

import com.google.gson.Gson;

import java.util.Date;

import cn.zpengc.application.local.model.Category;

public class Converters {

    private static Gson gson = new Gson();

    @TypeConverter
    public static Date Timestamp2Date(Long value) {
        return value == null ? null : new Date(value);
    }

    @TypeConverter
    public static Long date2Timestamp(Date date) {
        return date == null ? System.currentTimeMillis() : date.getTime();
    }

    @TypeConverter
    public static String Category2String(Category category) {
        return gson.toJson(category);
    }

    @TypeConverter
    public static Category String2Category(String value) {
        return gson.fromJson(value, Category.class);
    }

}
