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

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int admNo){
        studentsDb.remove(admNo);
        return "Student deleted successfully";
    }

    @PutMapping("/update_course")
    public Student updateCourse(@RequestParam("id") int admNo,@RequestParam("course") String newCourse){
        if(!studentsDb.containsKey(admNo)){
            throw new RuntimeException("Student doesn't exist");
        }
        Student student = studentsDb.get(admNo);
        student.setCourse(newCourse);
        return student;
    }
    @GetMapping("/get_total_students")
    public int getTotalStudent(){
        int total = 0;
        for(int admNo: studentsDb.keySet()){
            if(studentsDb.get(admNo).getAge()>25){
                total++;
            }
        }
        return total;
    }
}
