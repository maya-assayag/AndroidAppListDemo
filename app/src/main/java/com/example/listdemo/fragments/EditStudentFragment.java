package com.example.listdemo.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.listdemo.R;
import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

public class EditStudentFragment extends Fragment {



    public EditStudentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_student, container, false);



        int position = EditStudentFragmentArgs.fromBundle(getArguments()).getStudentPosition();

        displayStudentDetails(position, view);

        Button saveBtn = view.findViewById(R.id.edit_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateStudentDetails(position, view);
                Navigation.findNavController(view).popBackStack();
            }
        });

        Button cancelBtn = view.findViewById(R.id.edit_cancel_btn);
        cancelBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_editStudentFragment_pop));


        return view;
    }
    private void displayStudentDetails(int position, View view){
        EditText name = view.findViewById(R.id.edit_name);
        name.setText(Model.getInstance().getAllStudents().get(position).getName());
        EditText id = view.findViewById(R.id.edit_id);
        id.setText(Model.getInstance().getAllStudents().get(position).getId());
        EditText phone = view.findViewById(R.id.edit_phone);
        phone.setText(Model.getInstance().getAllStudents().get(position).getPhone());
        EditText address = view.findViewById(R.id.edit_address);
        address.setText(Model.getInstance().getAllStudents().get(position).getAddress());
        CheckBox checkBox = view.findViewById(R.id.edit_checked);
        checkBox.setChecked(Model.getInstance().getAllStudents().get(position).getChecked());
    }

    private void updateStudentDetails(int position, View view){
        EditText nameAfterEdit = view.findViewById(R.id.edit_name);
        EditText idAfterEdit = view.findViewById(R.id.edit_id);
        EditText phoneAfterEdit = view.findViewById(R.id.edit_phone);
        EditText addressAfterEdit = view.findViewById(R.id.edit_address);
        CheckBox checkedAfterEdit = view.findViewById(R.id.edit_checked);

        Student student = Model.getInstance().getAllStudents().get(position);
        student.setName(nameAfterEdit.getText().toString());
        student.setId(idAfterEdit.getText().toString());
        student.setPhone(phoneAfterEdit.getText().toString());
        student.setAddress(addressAfterEdit.getText().toString());
        student.setChecked(checkedAfterEdit.isChecked());
    }
}