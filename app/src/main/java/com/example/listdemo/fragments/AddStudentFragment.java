package com.example.listdemo.fragments;

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

public class AddStudentFragment extends Fragment {

    public AddStudentFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_student, container, false);

        EditText name = view.findViewById(R.id.add_name);
        EditText id = view.findViewById(R.id.add_id);
        EditText phone = view.findViewById(R.id.add_phone);
        EditText address = view.findViewById(R.id.add_address);
        CheckBox checked = view.findViewById(R.id.add_checked);

        Button saveBtn = view.findViewById(R.id.add_save_btn);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Model.getInstance().AddStudent(name.getText().toString(),
                        id.getText().toString(),
                        phone.getText().toString(),
                        address.getText().toString(),
                        checked.isChecked());
                Navigation.findNavController(view).popBackStack();
            }
        });

        Button cancelBtn = view.findViewById(R.id.add_cancel_btn);
        cancelBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_addStudentFragment_pop));
        return view;
    }
}