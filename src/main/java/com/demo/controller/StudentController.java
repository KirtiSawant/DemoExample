package com.demo.controller;

import com.demo.entity.Student;
import com.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("student")
    public Student createStud(@RequestBody Student student) {
        return studentService.createStud(student);
    }

    @GetMapping("student")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("student/{id}")
    public Optional<Student> getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentService.deleteStudent(id);
    }
}
