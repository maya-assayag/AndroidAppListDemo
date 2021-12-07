package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = Model.getInstance().getAllStudents();
        ListView list = findViewById(R.id.main_list_view);

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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
        ListView list = findViewById(R.id.main_list_view);

        MyAdapter adapter = new MyAdapter();
        list.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter{


        MyAdapter(){

        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.activity_list_item,null);

            Student student = data.get(position);

            TextView name = view.findViewById(R.id.list_item_name);
            TextView id = view.findViewById(R.id.list_item_id);
            TextView phone = view.findViewById(R.id.list_item_phone);
            TextView address = view.findViewById(R.id.list_item_address);
            CheckBox checked = view.findViewById(R.id.list_item_checked);

            name.setText(student.getName());
            id.setText(student.getId());
            phone.setText(student.getPhone());
            address.setText(student.getAddress());
            checked.setChecked(student.getChecked());

            checked.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(student.getChecked()==false)
                    {
                        student.setChecked(true);
                    }else{
                        student.setChecked(false);
                    }

                }
            });


            return view;
        }
    }
}