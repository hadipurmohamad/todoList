package com.example.todolist.view.Utils;

import androidx.room.TypeConverter;

import com.example.todolist.view.model.Priority;

import java.util.Date;

public class Convert {
@TypeConverter
    public static Date longToDate(Long l){
        return l==null?null:new Date(l);
    }
    @TypeConverter
    public static Long dateToLong(Date l){
        return l==null?null:l.getTime();
    }
    @TypeConverter
    public static String priortyToString(Priority priority){
    return  priority==null?null:priority.name();
    }
    @TypeConverter
    public static Priority StringToPriority(String value){
        return  value==null?null:Priority.valueOf(value);
    }
}
