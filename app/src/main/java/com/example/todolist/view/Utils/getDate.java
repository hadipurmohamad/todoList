package com.example.todolist.view.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class getDate {
    public static String getDate(Date date){
        SimpleDateFormat simpleDateFormat= (SimpleDateFormat) SimpleDateFormat.getDateInstance();
        simpleDateFormat.applyPattern("EEE, MMM d");
        return simpleDateFormat.format(date);
    }
}
