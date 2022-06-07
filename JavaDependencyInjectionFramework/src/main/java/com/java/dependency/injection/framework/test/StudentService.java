package com.java.dependency.injection.framework.test;

import com.java.dependency.injection.framework.core.annotations.MyOwnComponent;
import com.java.dependency.injection.framework.core.annotations.MyOwnAutoWired;

@MyOwnComponent
public class StudentService {

    @MyOwnAutoWired
    private StudentRepository repository;

    public Student getInformation(Integer id) {
        return repository.getStudentById(id);
    }
}
