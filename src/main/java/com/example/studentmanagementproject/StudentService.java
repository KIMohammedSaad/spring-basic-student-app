package com.example.studentmanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student getStudent(int admNo){
        return studentRepository.getStudent(admNo);
    }

    public String addStudent(Student student) {
        return studentRepository.addStudent(student);
    }

    public String getStudentByPathVariable(int admNo, String message) {
        Student s = studentRepository.getStudentByPathVariable(admNo);
        return s + message;
    }
}
