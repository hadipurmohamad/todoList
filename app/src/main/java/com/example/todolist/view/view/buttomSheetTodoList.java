package com.example.todolist.view.view;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.example.todolist.R;
import com.example.todolist.view.model.Priority;
import com.example.todolist.view.model.Task;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.chip.Chip;

import java.util.Calendar;
import java.util.Date;

public class buttomSheetTodoList extends BottomSheetDialogFragment implements View.OnClickListener {
    private ImageButton save, dateshow, priortyshow;
    private View clendergroup, priorty;
    private CalendarView clenderView;
    private sendDataForAdd sendDataForAdd;
    private Date duDate, addDate;
    private String taskHeader;
    private Priority priority;
    private Chip tomorrow, today, nextweek;
    private ViewmodelTask viewmodelTask;
    private shearedViemodel shearedViemodel;
    private EditText editText;
    private Task addTask;
    private String headerTask;
    private RadioButton High, medium, low;
    private boolean onOffupdate;

    Calendar calender = Calendar.getInstance();

    public buttomSheetTodoList(sendDataForAdd sendDataForAdd) {
        this.sendDataForAdd = sendDataForAdd;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        editText = view.findViewById(R.id.edt_task);
        dateshow = view.findViewById(R.id.ibtn_date);
        priortyshow = view.findViewById(R.id.ibtn_priorty);
        save = view.findViewById(R.id.ibtn_save);
        clendergroup = view.findViewById(R.id.date_group);
        priorty = view.findViewById(R.id.rd_group);
        today = view.findViewById(R.id.chip_today);
        tomorrow = view.findViewById(R.id.chip_tomorrow);
        nextweek = view.findViewById(R.id.chip_nextweek);
        clenderView = view.findViewById(R.id.calendarView);
        High = view.findViewById(R.id.rd_high);
        medium = view.findViewById(R.id.rd_medium);
        low = view.findViewById(R.id.rd_low);
        shearedViemodel = new ViewModelProvider(requireActivity()).get(com.example.todolist.view.view.shearedViemodel.class);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save.setOnClickListener(this);
        dateshow.setOnClickListener(this);
        priortyshow.setOnClickListener(this);
        High.setOnClickListener(this);
        medium.setOnClickListener(this);
        low.setOnClickListener(this);
        today.setOnClickListener(this);
        tomorrow.setOnClickListener(this);
        nextweek.setOnClickListener(this);
        addDate = Calendar.getInstance().getTime();
        priority = Priority.LOW;

        clenderView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            calender.clear();
            calender.set(year, month, dayOfMonth);
            duDate = calender.getTime();

        });
        save.setOnClickListener(v -> {
            headerTask = editText.getText().toString();
            if (onOffupdate) {
                addTask.setCreateDate(duDate);
                addTask.setTaskHeader(headerTask);
                addTask.setPriority(priority);
                sendDataForAdd.onItemClickForUpdate(addTask);

                dismiss();
            } else {

                if (!TextUtils.isEmpty(headerTask) & duDate != null) {
                    addTask = new Task(headerTask, priority, duDate, addDate);
                    Log.d("TAG", "onViewCreated: " + addTask);
                    sendDataForAdd.sendData(addTask);
                } else {
                    Toast.makeText(requireActivity(), "Insert complete information", Toast.LENGTH_SHORT).show();
                }
                dismiss();
            }
            onOffupdate = false;
        });
    }


    @Override
    public void onResume() {
        super.onResume();
        if (shearedViemodel.getisUpdate()) {
            onOffupdate = true;
            if (shearedViemodel.getdata().getValue() != null && shearedViemodel.getisUpdate()) {
                addTask = shearedViemodel.getdata().getValue();
                Log.d("TAG", "onResume: " + addTask.toString());
                editText.setText(addTask.getTaskHeader());
                priority = addTask.getPriority();
                duDate = addTask.getCreateDate();

                if (priority == Priority.HIGH) {
                    High.setChecked(true);
                } else if (priority == Priority.MEDIUM) {
                    medium.setChecked(true);
                } else {
                    low.setChecked(true);
                }
                shearedViemodel.setUpdate(false);
            }
        } else {
            editText.setText("");
        }

    }

    @Override
    public void onClick(View v) {

        int id = v.getId();
        if (dateshow.getId() == id) {
            clendergroup.setVisibility(clendergroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        } else if (priortyshow.getId() == id) {
            priorty.setVisibility(priorty.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        } else if (High.getId() == id) {
            priority = Priority.HIGH;
        } else if (medium.getId() == id) {
            priority = Priority.MEDIUM;
        } else if (low.getId() == id) {
            priority = Priority.LOW;
        } else if (today.getId() == id) {
            calender.add(Calendar.DAY_OF_YEAR, 0);
            duDate = calender.getTime();
        } else if (tomorrow.getId() == id) {
            calender.add(Calendar.DAY_OF_YEAR, 1);
            duDate = calender.getTime();
        } else if (nextweek.getId() == id) {
            calender.add(Calendar.DAY_OF_YEAR, 6);
            duDate = calender.getTime();
        }
    }

}