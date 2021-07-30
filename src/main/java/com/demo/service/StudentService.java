package com.demo.service;

import com.demo.entity.Branch;
import com.demo.entity.Student;
import com.demo.repo.BranchRepository;
import com.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    BranchRepository branchRepository;

    public Student createStud(Student student) {
           Long branch = student.getId();
        if(branch != null){
           int id = 1;
            Optional<Branch> branch1=branchRepository.findById(id);
            if(branch1.isPresent()){
                student.setId(branch);
            }
        }
        return studentRepository.save(student);
    }
}

