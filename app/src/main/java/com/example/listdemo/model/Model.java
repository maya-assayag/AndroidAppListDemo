package com.example.listdemo.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private final static Model instance = new Model();
    List<Student> data = new LinkedList<>();

    private Model(){

    }

    public static Model getInstance() {
        return instance;
    }

    public List<Student> getAllStudents() {
        return data;
    }

    public void AddStudent(String name, String id, String phone, String address){
        Student student = new Student();

        student.setName(name);
        student.setId(id);
        student.setPhone(phone);
        student.setAddress(address);

        data.add(student);
    }
}
