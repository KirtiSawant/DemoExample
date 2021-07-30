package com.demo.controller;

import com.demo.entity.Employee;
import com.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @PostMapping("employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return this.employeeService.createEmployee(employee);
    }

    @GetMapping("employee")
    public List<Employee> getEmp() {
        return employeeService.getEmp();
    }

    @GetMapping("employee/search")
    public List<Employee> getAllEmp(@RequestParam (required = false)String firstName,
                                    @RequestParam (required = false)String lastName,
                                    @RequestParam (defaultValue = "0")Integer page,
                                    @RequestParam (defaultValue = "5")Integer size,
                                    @RequestParam (defaultValue = "salary")String sortBy) {
        return employeeService.getAllEmp(firstName,lastName,page,size,sortBy);
    }

        @GetMapping("employee/{id}")
        public Employee grtEmpByID(@PathVariable("id") int id){
        return employeeService.getEmpById(id);
    }



}
