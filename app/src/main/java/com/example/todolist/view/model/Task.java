package com.example.todolist.view.model;

import android.renderscript.RenderScript;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity(tableName = "Task_table")
public class Task {
    @PrimaryKey(autoGenerate = true)
    @NotNull()
    private int taskId ;

    public Task(String taskHeader, Priority priority, Date createDate, Date addDate) {
        this.taskHeader = taskHeader;
        this.priority = priority;
        this.createDate = createDate;
        this.addDate = addDate;
    }


    @ColumnInfo(name="taskHeader")
    private String taskHeader;

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskHeader() {
        return taskHeader;
    }

    public void setTaskHeader(String taskHeader) {
        this.taskHeader = taskHeader;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    @ColumnInfo(name="priority")
    private Priority priority;
    @ColumnInfo(name="createDate")
    private Date createDate;
    @ColumnInfo(name="addDate")
    private Date addDate ;

}
