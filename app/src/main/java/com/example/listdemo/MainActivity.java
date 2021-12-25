package com.example.listdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.listdemo.adapters.StudentAdapter;
import com.example.listdemo.fragments.StudentListFragment;
import com.example.listdemo.fragments.TabBarFragment;
import com.example.listdemo.model.Model;
import com.example.listdemo.model.Student;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView list;
    StudentAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final TabBarFragment tabBar = new TabBarFragment();
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.main_frg_container,tabBar);
//        transaction.commit();
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//
//        data = Model.getInstance().getAllStudents();
//        adapter.notifyDataSetChanged();


//    }



}