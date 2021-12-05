package com.example.listdemo.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private final static Model instance = new Model();
    List<Student> data = new LinkedList<>();

    private Model(){
        Student s= new Student();

        s.setName("Maya Assayag");
        s.setId("20452742");
        s.setPhone("0529457221");
        s.setAddress("The Eraz 2");

        for (int i=0 ; i<10 ; i++){
            data.add(s);
        }

    }

    public static Model getInstance() {
        return instance;
    }

    public List<Student> getAllStudents() {
        return data;
    }
}
