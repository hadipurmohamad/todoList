package com.example.todolist.view.data;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.todolist.view.model.Task;
import com.example.todolist.view.model.taskDao;

import java.util.List;

public class RepositoryTask {

    private final taskDao taskDao;
    private final LiveData<List<Task>> allData;
    public  RepositoryTask (Application application){
        taskDao = RoomDatabaseTask.getInstance(application).taskDao();
      allData=taskDao.getAllList();
    }
 public LiveData<List<Task>> allTaskList(){return allData;}
 public void insetTask(Task task){taskDao.addTask(task);}
 public void updateTask(Task task){taskDao.updateTask(task);}
 public Task getTask(int id ){return taskDao.getTask(id);}
 public void deleteTask(Task task){taskDao.deleteTask(task);}
}
