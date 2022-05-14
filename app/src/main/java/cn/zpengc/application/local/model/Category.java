package cn.zpengc.application.local.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Category {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "desc", defaultValue = "")
    private String desc;

    @ColumnInfo(name = "ctime")
    private Date ctime;

    @ColumnInfo(name = "mtime")
    private Date mtime;

    @ColumnInfo(name = "deleted", defaultValue = "0")
    private int deleted;

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public Date getCtime() {
        return ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }


    @Override
    public String toString() {
        return "Category{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", deleted=" + deleted +
                '}';
    }
}
