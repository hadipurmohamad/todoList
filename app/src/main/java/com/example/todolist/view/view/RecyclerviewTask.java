package com.example.todolist.view.view;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.todolist.R;
import com.example.todolist.view.Utils.getDate;
import com.example.todolist.view.model.Task;
import com.google.android.material.chip.Chip;
import java.util.List;
public class RecyclerviewTask extends RecyclerView.Adapter<RecyclerviewTask.Viewholder> {
private final List<Task> allTask;

    public RecyclerviewTask(List<Task> allTask) {
        this.allTask = allTask;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_todo_list,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Task task = allTask.get(position);
        holder.headerTask.setText(task.getTaskHeader());
        Log.d("TAG", "onBindViewHolder: "+getDate.getDate(task.getAddDate()));
        holder.showDate.setText( getDate.getDate(task.getAddDate()));
    }

    @Override
    public int getItemCount() {
        return allTask.size();
    }

    public static class Viewholder extends RecyclerView.ViewHolder {
        AppCompatTextView headerTask;
        Chip showDate;
        AppCompatCheckBox radioButton;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            headerTask=itemView.findViewById(R.id.task_header);
            showDate= itemView.findViewById(R.id.date_chip);
            radioButton=itemView.findViewById(R.id.done_task_check);

        }


    }
}
