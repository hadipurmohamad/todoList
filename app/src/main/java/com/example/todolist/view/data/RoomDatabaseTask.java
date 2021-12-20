package com.example.todolist.view.data;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.example.todolist.view.Utils.Convert;
import com.example.todolist.view.model.Task;
import com.example.todolist.view.model.taskDao;
@Database(entities = {Task.class}, version = 1, exportSchema = false)
@TypeConverters({Convert.class})
public abstract class RoomDatabaseTask extends RoomDatabase {
    public abstract taskDao taskDao();

    private static RoomDatabaseTask roomDatabaseTask;



    public static RoomDatabaseTask getInstance(final Context context) {
        if (roomDatabaseTask == null) {
            synchronized (RoomDatabaseTask.class) {
                if (roomDatabaseTask == null) {
                    roomDatabaseTask = Room.databaseBuilder(context.getApplicationContext(),
                            RoomDatabaseTask.class,
                            "Task_db").allowMainThreadQueries().build();

                }
            }
        }
        return roomDatabaseTask;
    }

}
