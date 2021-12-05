package com.example.listdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText name = findViewById(R.id.add_name);
        EditText id = findViewById(R.id.add_id);
        EditText phone = findViewById(R.id.add_phone);
        EditText address = findViewById(R.id.add_address);

        Button saveBtn = findViewById(R.id.add_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().AddStudent(name.getText().toString(),
                        id.getText().toString(),
                        phone.getText().toString(),
                        address.getText().toString());
                Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button cancelBtn = findViewById(R.id.add_cancel_btn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddStudentActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}