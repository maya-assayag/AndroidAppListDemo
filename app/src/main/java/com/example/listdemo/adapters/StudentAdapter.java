package com.example.listdemo.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdemo.MainActivity;
import com.example.listdemo.R;
import com.example.listdemo.model.Student;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentViewHolder>{

    public List<Student> data;
    LayoutInflater inflater;

    public StudentAdapter(LayoutInflater inflater){
        this.inflater = inflater;
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }


    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }
    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.activity_list_item,null);
        StudentViewHolder viewHolder = new StudentViewHolder(view,listener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student = data.get(position);

        holder.bindStudentData(student, position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


}
