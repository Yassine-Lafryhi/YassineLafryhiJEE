package com.java.dependency.injection.framework.test;

public class Student {
    private Integer id;
    private String fullName;
    private Double grade;

    public Student() {
    }

    public Student(Integer id, String fullName, Double grade) {
        this.id = id;
        this.fullName = fullName;
        this.grade = grade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return this.id + "- " + this.fullName + " Has : " + this.grade;
    }
}
