package com.example.listdemo.adapters;

import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.listdemo.R;
import com.example.listdemo.model.Student;

public class StudentViewHolder extends  RecyclerView.ViewHolder{

    TextView name;
    TextView id;
    TextView phone;
    TextView address;
    CheckBox checked;

    public StudentViewHolder(@NonNull View itemView, StudentAdapter.OnItemClickListener listener) {
        super(itemView);

        name = itemView.findViewById(R.id.list_item_name);
        id = itemView.findViewById(R.id.list_item_id);
        phone = itemView.findViewById(R.id.list_item_phone);
        address = itemView.findViewById(R.id.list_item_address);
        checked = itemView.findViewById(R.id.list_item_checked);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","#############");
                if(listener != null){
                    int position = getAdapterPosition();
                    if(position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            }
        });

        checked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG","detect a click");
            }
        });
    }

    public void bindStudentData(Student student , int position){
        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checked.setChecked(student.getChecked());
    }


}
