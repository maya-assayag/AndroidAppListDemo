package com.example.listdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.listdemo.R;
import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;

public class StudentDetailsFragment extends Fragment {


    public StudentDetailsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_details, container, false);

        List<Student> data = Model.getInstance().getAllStudents();


        int position = StudentDetailsFragmentArgs.fromBundle(getArguments()).getStudenPosition();

        Student student = data.get(position);
        displayStudentDetails(student, view);

        Button deleteBtn = view.findViewById(R.id.details_delete_btn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model.getInstance().DeleteStudent(position);
                Navigation.findNavController(view).popBackStack();
            }
        });

        Button editBtn = view.findViewById(R.id.details_edit_btn);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDetailsFragmentDirections.ActionStudentDetailsFragmentToEditStudentFragment action =
                        StudentDetailsFragmentDirections.actionStudentDetailsFragmentToEditStudentFragment(position);
                Navigation.findNavController(view).navigate(action);
            }
        });


        return view;
    }
    private void displayStudentDetails(Student student, View view){
        TextView name = view.findViewById(R.id.details_name);
        TextView id = view.findViewById(R.id.details_id);
        TextView phone = view.findViewById(R.id.details_phone);
        TextView address = view.findViewById(R.id.details_address);
        CheckBox checkBox = view.findViewById(R.id.details_checkBox);

        name.setText(student.getName());
        id.setText(student.getId());
        phone.setText(student.getPhone());
        address.setText(student.getAddress());
        checkBox.setChecked(student.getChecked());
    }
}