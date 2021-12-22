package com.example.todolist.view.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.example.todolist.R;
import com.example.todolist.view.model.Task;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements sendDataForAdd, onItemClick {
    private buttomSheetTodoList buttomSheetTodoList;
    private FloatingActionButton floatingActionButton;
    private ConstraintLayout constraintLayout;
    private ViewmodelTask viewmodelTask;
    private RecyclerView recyclerView;
    private RecyclerviewTask recyclerviewTask;
    private shearedViemodel shearedViemodel;
    public static final String TAG = "hadi";
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
shearedViemodel= new ViewModelProvider(this).get(com.example.todolist.view.view.shearedViemodel.class);


        recyclerView = findViewById(R.id.recycler_todo_task);
        viewmodelTask = new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(ViewmodelTask.class);
        constraintLayout = findViewById(R.id.bottomsheet_constrain);
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
        bottomSheetBehavior.setPeekHeight(BottomSheetBehavior.STATE_HIDDEN);
        buttomSheetTodoList = new buttomSheetTodoList(this);
        floatingActionButton = findViewById(R.id.fbv_btn_new);
        floatingActionButton.setOnClickListener(view -> {
            showBottomsheetdialog();
        });
        viewmodelTask.getAllTaskList().observe(this, tasks -> {
            recyclerviewTask = new RecyclerviewTask(tasks, this);
            recyclerView.setAdapter(recyclerviewTask);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        });
    }

    private void showBottomsheetdialog() { buttomSheetTodoList.show(getSupportFragmentManager(), buttomSheetTodoList.getTag()); }

    @Override
    public void sendData(Task task) {
        if (task!=null){
            viewmodelTask.insertTask(task);
        }else{
            Log.d(TAG, "NULL ");

        }

    }

    @Override
    public void onItemClickForUpdate(Task task) {

        if (task!=null){
            viewmodelTask.updateTask(task);
    }else{
        Log.d(TAG, "NULL ");

    }
    }

    @Override
    public void onItemClick(Task task) {
        viewmodelTask.deleteTask(task);
    }

    @Override
    public void onItemClickUpdate(Task task) {
        shearedViemodel.setMutableLiveData(task);
        shearedViemodel.setUpdate(true);

        showBottomsheetdialog();
    }
}
