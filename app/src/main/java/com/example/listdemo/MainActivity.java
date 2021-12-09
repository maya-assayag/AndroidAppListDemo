package com.example.listdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<Student> data;
    RecyclerView list;
    MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = Model.getInstance().getAllStudents();

        list = findViewById(R.id.main_list_view);
        list.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);

        adapter = new MyAdapter();
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.d("TAG","row was clicked " + position);
                Intent intent = new Intent(MainActivity.this, StudentDetailsActivity.class );
                intent.putExtra("Position", position);
                startActivity(intent);
            }
        });


        Button addBtn = findViewById(R.id.main_add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        data = Model.getInstance().getAllStudents();
        adapter.notifyDataSetChanged();


    }
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView id;
        TextView phone;
        TextView address;
        CheckBox checked;

        public MyViewHolder(@NonNull View itemView, OnItemClickListener listener) {
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

        private void bindStudentData(Student student , int position){
            name.setText(student.getName());
            id.setText(student.getId());
            phone.setText(student.getPhone());
            address.setText(student.getAddress());
            checked.setChecked(student.getChecked());
        }
    }

    interface OnItemClickListener{
        void onItemClick(int position);
    }

    class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.activity_list_item,null);
            MyViewHolder viewHolder = new MyViewHolder(view,listener);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            Student student = data.get(position);

            holder.bindStudentData(student, position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

    }
}