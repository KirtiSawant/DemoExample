package com.demo.controller;

import com.demo.entity.Branch;
import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public Student createStud(@RequestBody Student student){
        return studentService.createStud(student);
    }
}
