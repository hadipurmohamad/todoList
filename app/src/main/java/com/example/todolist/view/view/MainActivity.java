package com.example.todolist.view.view;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.todolist.R;
import com.example.todolist.view.model.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private buttomSheetTodoList buttomSheetTodoList;
    private FloatingActionButton floatingActionButton;
    private ConstraintLayout constraintLayout;
    private ViewmodelTask viewmodelTask;
    private RecyclerView recyclerView;
    private RecyclerviewTask recyclerviewTask;
    public static final String TAG = "log_hadi";
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycler_todo_task);
        viewmodelTask= new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(ViewmodelTask.class);
        constraintLayout = findViewById(R.id.bottomsheet_constrain);
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
        bottomSheetBehavior.setPeekHeight(bottomSheetBehavior.STATE_HIDDEN);
        floatingActionButton = findViewById(R.id.fbv_btn_new);
        floatingActionButton.setOnClickListener(view -> {
            showBottomsheetdialog();
        });
        viewmodelTask.getAllTaskList().observe(this, new Observer<List<Task>>() {
            @Override
            public void onChanged(List<Task> tasks) {
                Log.d(TAG, "onChanged: "+tasks.size());
        recyclerviewTask = new RecyclerviewTask(tasks);
        recyclerView.setAdapter(recyclerviewTask);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
            }
        });


    }
    private void showBottomsheetdialog() {
//        Task task = new Task("eating lunch2", Priority.HIGH,new Date(12316546),new Date(13245498));
        buttomSheetTodoList = new buttomSheetTodoList();
        buttomSheetTodoList.show(getSupportFragmentManager(), buttomSheetTodoList.getTag());
    }
}