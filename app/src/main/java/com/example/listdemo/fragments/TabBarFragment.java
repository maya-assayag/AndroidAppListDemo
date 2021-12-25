package com.example.listdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listdemo.R;

public class TabBarFragment extends Fragment implements View.OnClickListener {

    Fragment[] tabs = new Fragment[3];

    public TabBarFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab_bar, container, false);
        Button allStudentsBtn = view.findViewById(R.id.tab_bar_fragment_all_students_btn);
        Button addStudentBtn = view.findViewById(R.id.nav_bar_fragment_add_student_btn);

        allStudentsBtn.setTag(0);
        addStudentBtn.setTag(2);

        allStudentsBtn.setOnClickListener(this);
        addStudentBtn.setOnClickListener(this);

        tabs[0] = new StudentListFragment();
        tabs[2] = new AddStudentFragment();

        return view;
    }

    @Override
    public void onClick(View view) {
        int selected = (int)view.getTag();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.tab_bar_fragment_container,tabs[selected]);
        transaction.commit();


    }
}