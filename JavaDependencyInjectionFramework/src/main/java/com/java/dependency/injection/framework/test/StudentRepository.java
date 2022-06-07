package com.java.dependency.injection.framework.test;

import com.java.dependency.injection.framework.core.annotations.MyOwnComponent;

import java.util.HashMap;
import java.util.Map;

@MyOwnComponent
public class StudentRepository {
    Map<Integer, Student> students = new HashMap<>();

    StudentRepository() {
        students.put(1, new Student(1, "AHMED CHARIF", 15.25));
        students.put(2, new Student(2, "HAFSA LOTFY", 18.50));
        students.put(3, new Student(2, "SAMIR AMRANY", 19.25));
        students.put(4, new Student(2, "ASSIYA KAMILY", 19.75));
    }

    public Student getStudentById(Integer id) {
        return students.get(id);
    }
}
