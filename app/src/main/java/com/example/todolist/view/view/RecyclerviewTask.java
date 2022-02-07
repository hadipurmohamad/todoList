package com.example.todolist.view.view;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todolist.R;
import com.example.todolist.view.Utils.getDate;
import com.example.todolist.view.model.Priority;
import com.example.todolist.view.model.Task;
import com.google.android.material.chip.Chip;

import java.util.List;
//برای ایجاد recyclerview باید از کلاس  RecyclerView.Adapter ارث بری کنیم و این کلاس خود یک نوع کلاس می خواهد که داخل < > نوشته می شود
//این کلاس را باید ایجاد کنیم که می تواند زیر کلاس همین کلاس هم باشد که در اینجا این چنین عمل کردیم
// و خود همین کلاس هم باید از کلاس RecyclerView.viewholder  ارث بری کند زیر کلاس ما هم در این جا  نامش  viewholder است
public class RecyclerviewTask extends RecyclerView.Adapter<RecyclerviewTask.Viewholder> {
    private final List<Task> allTask;
    public static final String TAG = "hadi";
    private final onItemClick ontodoItemClick;
    public int id;

//بعد از ساخت کلاسها و ارث بری ها متد هایی هستند که باید  override کنیم
    public RecyclerviewTask(List<Task> allTask, onItemClick onItemClick) {
        this.allTask = allTask;

        this.ontodoItemClick = onItemClick;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_todo_list, parent, false);
        return new Viewholder(view);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Task task = allTask.get(position);
        ColorStateList colorStateList = new ColorStateList(
                new int[][]{
                        new int[]{-android.R.attr.state_enabled},
                        new int[]{android.R.attr.state_enabled}
                }, new int[]{
                Color.LTGRAY,
                getDate.prioritycolor(task)
        }
        );

        holder.headerTask.setText(task.getTaskHeader());
        holder.showDate.setText(getDate.getDate(task.getCreateDate()));
holder.showDate.setTextColor(getDate.prioritycolor(task));
holder.showDate.setChipIconTint(colorStateList);

    }


    @Override
    public int getItemCount() {
        return allTask.size();
    }


    public class Viewholder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatTextView headerTask;
        Chip showDate;
        AppCompatCheckBox radioButton;
        ConstraintLayout constraintLayout;
        onItemClick onItemClick2;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            headerTask = itemView.findViewById(R.id.task_header);
            showDate = itemView.findViewById(R.id.date_chip);
            radioButton = itemView.findViewById(R.id.done_task_check);
            constraintLayout = itemView.findViewById(R.id.row_todo_row);

            radioButton.setOnClickListener(this);
            this.onItemClick2 = ontodoItemClick;
        }


        @Override
        public void onClick(View v) {
            Task task = allTask.get(getAdapterPosition());
            int id = v.getId();
            if (id == radioButton.getId()) {

                onItemClick2.onItemClick(task);
            } else if (id == constraintLayout.getId()) {
                onItemClick2.onItemClickUpdate(task);
            }
//
        }


    }

}
