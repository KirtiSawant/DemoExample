package com.example.service;

import com.example.dao.EmpRepository;
import com.example.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpRepository empRepository;

    public Employee createEmp(Employee employee) {
        return this.empRepository.save(employee);
    }

    public List<Employee> getAllEmp() {
        return (List<Employee>) empRepository.findAll();
    }

    public Employee getEmp(int id) {
        empRepository.findById(id);
        return new Employee();
    }
}
