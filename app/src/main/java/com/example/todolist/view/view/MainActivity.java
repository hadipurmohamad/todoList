package com.example.todolist.view.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;
import android.annotation.SuppressLint;
import android.os.Bundle;
import com.example.todolist.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class MainActivity extends AppCompatActivity {
    private buttomSheetTodoList buttomSheetTodoList;
    private FloatingActionButton floatingActionButton;
    private ConstraintLayout constraintLayout;
    private ViewmodelTask viewmodelTask;
    public static final String TAG = "log_hadi";
    @SuppressLint("ServiceCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewmodelTask= new ViewModelProvider.AndroidViewModelFactory(this.getApplication()).create(ViewmodelTask.class);
        constraintLayout = findViewById(R.id.bottomsheet_constrain);
        BottomSheetBehavior<ConstraintLayout> bottomSheetBehavior = BottomSheetBehavior.from(constraintLayout);
        bottomSheetBehavior.setPeekHeight(bottomSheetBehavior.STATE_HIDDEN);
        floatingActionButton = findViewById(R.id.fbv_btn_new);
        floatingActionButton.setOnClickListener(view -> {
            showBottomsheetdialog();
        });
    }
    private void showBottomsheetdialog() {
//        Task task = new Task("eating lunch2", Priority.HIGH,new Date(12316546),new Date(13245498));
        buttomSheetTodoList = new buttomSheetTodoList();
        buttomSheetTodoList.show(getSupportFragmentManager(), buttomSheetTodoList.getTag());
    }
}