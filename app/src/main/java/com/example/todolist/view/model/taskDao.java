package com.example.todolist.view.model;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface taskDao {
    @Insert
    public void addTask(Task task);

    @Query("SELECT * FROM Task_table")
    public LiveData<List<Task>> getAllList();

    @Query("SELECT * FROM Task_table WHERE taskId=:id")
    public Task getTask(int id);

    @Delete
    public void deleteTask(Task task);

    @Update
    public void updateTask(Task task);


}
