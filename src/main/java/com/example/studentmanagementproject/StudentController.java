package com.example.studentmanagementproject;

import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class StudentController {
    Map<Integer,Student> studentsDb = new HashMap<>();

    @GetMapping("/get_info")
    public Student getStudent(@RequestParam("id") int admNo){
        return studentsDb.get(admNo);
    }

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){
         studentsDb.put(student.getAdmNo(), student);
         return "Student added successfully";
    }
    @GetMapping("/get/{id}/{message}")
    public String  getStudentByPathVariable(@PathVariable("id") int admNo, @PathVariable(value = "message") String message){
//        if(message==null){
//            return "Plz pass msg";
//        }
        return studentsDb.get(admNo) + message;
    }
}
