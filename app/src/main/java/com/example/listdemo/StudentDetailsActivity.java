package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
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
        int position = intent.getIntExtra("Position",0);
        Student student = data.get(position);

        TextView name = findViewById(R.id.details_name);
        TextView id = findViewById(R.id.details_id);
        TextView phone = findViewById(R.id.details_phone);
        TextView address = findViewById(R.id.details_address);
        CheckBox checkBox = findViewById(R.id.details_checkBox);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checkBox.setChecked(student.getChecked());

        Button deleteBtn = findViewById(R.id.details_delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().DeleteStudent(position);
                finish();
            }
        });

        Button editBtn = findViewById(R.id.details_edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextIntent = new Intent(StudentDetailsActivity.this, EditStudentActivity.class);
                nextIntent.putExtra("StudentPosition",position);
                startActivity(nextIntent);

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Student> data = Model.getInstance().getAllStudents();

        Intent intent = getIntent();
        int position = intent.getIntExtra("Position",0);
        Student student = data.get(position);

        TextView name = findViewById(R.id.details_name);
        TextView id = findViewById(R.id.details_id);
        TextView phone = findViewById(R.id.details_phone);
        TextView address = findViewById(R.id.details_address);
        CheckBox checkBox = findViewById(R.id.details_checkBox);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checkBox.setChecked(student.getChecked());
    }
}