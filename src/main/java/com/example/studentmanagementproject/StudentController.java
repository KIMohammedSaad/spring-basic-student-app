package com.example.studentmanagementproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/get_info")
    public ResponseEntity getStudent(@RequestParam("id") int admNo){
        Student s = studentService.getStudent(admNo);
        if(s==null){
            return new ResponseEntity("Student not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(s,HttpStatus.ACCEPTED);
    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String s = studentService.addStudent(student);
         return new ResponseEntity(s, HttpStatus.CREATED);
    }
    @GetMapping("/get/{id}/{message}")
    public String  getStudentByPathVariable(@PathVariable("id") int admNo, @PathVariable(value = "message") String message){
        return studentService.getStudentByPathVariable(admNo,message);
    }

//    @DeleteMapping("/delete")
//    public String deleteStudent(@RequestParam("id") int admNo){
//        studentsDb.remove(admNo);
//        return "Student deleted successfully";
//    }
//
//    @PutMapping("/update_course")
//    public Student updateCourse(@RequestParam("id") int admNo,@RequestParam("course") String newCourse){
//        if(!studentsDb.containsKey(admNo)){
//            throw new RuntimeException("Student doesn't exist");
//        }
//        Student student = studentsDb.get(admNo);
//        student.setCourse(newCourse);
//        return student;
//    }
//    @GetMapping("/get_total_students")
//    public int getTotalStudent(){
//        int total = 0;
//        for(int admNo: studentsDb.keySet()){
//            if(studentsDb.get(admNo).getAge()>25){
//                total++;
//            }
//        }
//        return total;
//    }
}
