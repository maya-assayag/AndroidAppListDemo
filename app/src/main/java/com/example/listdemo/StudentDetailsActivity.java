package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;

public class StudentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        List<Student> data = Model.getInstance().getAllStudents();

        Intent intent = getIntent();
        Student student = data.get(intent.getIntExtra("Position",0));

        TextView name = findViewById(R.id.details_name);
        TextView id = findViewById(R.id.details_id);
        TextView phone = findViewById(R.id.details_phone);
        TextView address = findViewById(R.id.details_address);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
    }
}