package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

public class EditStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);

        Intent intent = getIntent();
        int position = intent.getIntExtra("StudentPosition",0);

        EditText name = findViewById(R.id.edit_name);
        name.setText(Model.getInstance().getAllStudents().get(position).getName());
        EditText id = findViewById(R.id.edit_id);
        id.setText(Model.getInstance().getAllStudents().get(position).getId());
        EditText phone = findViewById(R.id.edit_phone);
        phone.setText(Model.getInstance().getAllStudents().get(position).getPhone());
        EditText address = findViewById(R.id.edit_address);
        address.setText(Model.getInstance().getAllStudents().get(position).getAddress());

        Button saveBtn = findViewById(R.id.edit_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nameAfterEdit = findViewById(R.id.edit_name);
                EditText idAfterEdit = findViewById(R.id.edit_id);
                EditText phoneAfterEdit = findViewById(R.id.edit_phone);
                EditText addressAfterEdit = findViewById(R.id.edit_address);

                Student student = Model.getInstance().getAllStudents().get(position);
                student.setName(nameAfterEdit.getText().toString());
                student.setId(idAfterEdit.getText().toString());
                student.setPhone(phoneAfterEdit.getText().toString());
                student.setAddress(addressAfterEdit.getText().toString());

                finish();
            }
        });

        Button deleteBtn = findViewById(R.id.edit_cancel_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}