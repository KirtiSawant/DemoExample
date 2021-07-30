package com.demo.service;

import com.demo.entity.Employee;
import com.demo.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee createEmployee(Employee employee) {
        return (Employee) this.employeeRepository.save(employee);
    }


    public List<Employee> getEmp() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmpById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmp(String firstName, String lastName,Integer page, Integer size,String sortBy) {
        Sort sortOrder = Sort.by("age");
        List<Employee> list = (List<Employee>) employeeRepository.findAll(sortOrder);
        if (list.isEmpty()) {
            return list;
        }
        Pageable paging = PageRequest.of(page,size,Sort.by(sortBy));
        Page<Employee> pageResult;
        if (firstName == null || lastName ==null)
            pageResult = employeeRepository.findAll(paging);
        else
            pageResult = employeeRepository.findByFirstNameAndLastName(firstName,lastName, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
}
