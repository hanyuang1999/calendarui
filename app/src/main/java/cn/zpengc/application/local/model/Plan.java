package cn.zpengc.application.local.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity
public class Plan {

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

    @ColumnInfo(name = "deadline")
    private String deadline;

    @ColumnInfo(name = "deleted", defaultValue = "0")
    private int deleted;

    @ColumnInfo(name = "state", defaultValue = "0")
    private int state;

    @ColumnInfo(name = "category")
    private Category category;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getMtime() {
        return mtime;
    }

    public void setMtime(Date mtime) {
        this.mtime = mtime;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", ctime=" + ctime +
                ", mtime=" + mtime +
                ", deadline='" + deadline + '\'' +
                ", deleted=" + deleted +
                ", state=" + state +
                ", category=" + category +
                '}';
    }
}
