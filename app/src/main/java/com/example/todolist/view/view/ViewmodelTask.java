package com.example.todolist.view.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.todolist.view.data.RepositoryTask;
import com.example.todolist.view.model.Task;

import java.util.List;

public  class ViewmodelTask extends AndroidViewModel {
    private final LiveData<List<Task>> allTaskList;
    private  RepositoryTask repositoryTask;
    public ViewmodelTask(@NonNull Application application) {
        super(application);
        if (repositoryTask==null) repositoryTask = new RepositoryTask(application);
        allTaskList= repositoryTask.allTaskList();
    }
    public LiveData<List<Task>> getAllTaskList(){return repositoryTask.allTaskList();}
    public Task getTask(int id){return repositoryTask.getTask(id);}
    public void insertTask(Task task){repositoryTask.insetTask(task);}
    public void updateTask(Task task){repositoryTask.updateTask(task);}
    public void deleteTask(Task task){repositoryTask.deleteTask(task);}
}
