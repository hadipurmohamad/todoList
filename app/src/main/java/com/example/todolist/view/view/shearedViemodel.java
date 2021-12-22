package com.example.todolist.view.view;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolist.view.model.Task;

public class shearedViemodel extends ViewModel {
    private final MutableLiveData<Task> mutableLiveData=new MutableLiveData<Task>();
    private boolean isUpdate;

    public boolean getisUpdate() {
        return isUpdate;
    }

    public void setUpdate(boolean update) {
        this.isUpdate = update;
    }

    public void setMutableLiveData (Task task){
        mutableLiveData.setValue(task);
    }
    public LiveData<Task> getdata(){
        return mutableLiveData;
    }
}

