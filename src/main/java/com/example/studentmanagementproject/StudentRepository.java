package com.example.studentmanagementproject;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {
    Map<Integer,Student> studentsDb = new HashMap<>();

    public Student getStudent(int admNo){
        return studentsDb.get(admNo);
    }

    public String addStudent(Student student) {
        if(studentsDb.containsKey(student.getAdmNo())){
            return "Student already present";
        }
        studentsDb.put(student.getAdmNo(),student);
            return "Student added successfully";

    }

    public Student getStudentByPathVariable(int admNo) {
        return studentsDb.get(admNo);
    }
}
