package com.example.listdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.listdemo.R;
import com.example.listdemo.adapters.StudentAdapter;
import com.example.listdemo.fragments.StudentDetailsFragment;
import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;
import java.util.NavigableMap;


public class StudentListFragment extends Fragment {


    public StudentListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_student_list, container, false);

        Button addStudentBtn = view.findViewById(R.id.student_list_fragment_add_new_student_btn);
        addStudentBtn.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_studentListFragment_to_addStudentFragment));

        RecyclerView studentList = view.findViewById(R.id.student_list_fragment_recycler_view);

        studentList.hasFixedSize();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        studentList.setLayoutManager(layoutManager);

        List<Student> data = Model.getInstance().getAllStudents();

        StudentAdapter adapter = new StudentAdapter(getLayoutInflater());
        adapter.data = data;
        studentList.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                StudentListFragmentDirections.ActionStudentListFragmentToStudentDetailsFragment action =
                        StudentListFragmentDirections.actionStudentListFragmentToStudentDetailsFragment(position);
                Navigation.findNavController(view).navigate(action);
            }
        });

        return view;
    }


}