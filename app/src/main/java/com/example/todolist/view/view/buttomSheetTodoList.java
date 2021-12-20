package com.example.todolist.view.view;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.todolist.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
public class buttomSheetTodoList extends BottomSheetDialogFragment implements View.OnClickListener {
    private ImageButton save, dateshow, priortyshow;
    private View clendergroup, priorty;
    public buttomSheetTodoList() {
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);
        dateshow = view.findViewById(R.id.ibtn_date);
        priortyshow = view.findViewById(R.id.ibtn_priorty);
        save = view.findViewById(R.id.ibtn_save);
        clendergroup = view.findViewById(R.id.date_group);
        priorty = view.findViewById(R.id.rd_group);
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        save.setOnClickListener(this);
        dateshow.setOnClickListener(this);
        priortyshow.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (dateshow.getId() == id) {
            clendergroup.setVisibility(clendergroup.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        } else if (priortyshow.getId() == id) {
            priorty.setVisibility(priorty.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
        } else if (save.getId() == id) {

        }
    }
}