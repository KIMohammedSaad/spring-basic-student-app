package com.example.studentmanagementproject;

public class Student {
    private int admNo;
    private String name;
    private int age;
    private String course;

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "admNo=" + admNo +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                '}';
    }

    public int getAdmNo() {
        return admNo;
    }

    public void setAdmNo(int admNo) {
        this.admNo = admNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Student(int admNo, String name, int age, String course) {
        this.admNo = admNo;
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
