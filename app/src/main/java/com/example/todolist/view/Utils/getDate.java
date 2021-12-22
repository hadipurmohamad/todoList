package com.example.todolist.view.Utils;

import android.graphics.Color;

import com.example.todolist.view.model.Priority;
import com.example.todolist.view.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
    public static String getDate(Date date){
        SimpleDateFormat simpleDateFormat= (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("EEE, MMM d");
        return simpleDateFormat.format(date);
    }

    public static int prioritycolor(Task task) {
        int color;
        if (task.getPriority()== Priority.HIGH){
            color= Color.argb(200,201,21,23);
        }else if (task.getPriority()== Priority.MEDIUM){
            color= Color.argb(200,155,179,0);
        }else {

            color= Color.argb(200,51,181,129);
        }
        return color;
    }
}
