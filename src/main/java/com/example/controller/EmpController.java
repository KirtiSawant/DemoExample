package com.example.controller;

import com.example.exception.CustomerNotFoundException;
import com.example.model.Employee;
import com.example.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

   @PostMapping("employee")
    public Employee createEmp(@RequestBody Employee employee){
        return this.empService.createEmp(employee);
    }

    @GetMapping("emp")
    public List<Employee> getAllEmp() throws CustomerNotFoundException {
       return empService.getAllEmp();
    }

    @GetMapping("/customer/{id}")
    public  Employee getEmp(@PathVariable int id) throws CustomerNotFoundException {
        if (id == 1) {
            throw new CustomerNotFoundException();
        }
        return empService.getEmp(id);
        //new Employee();
    }

    @ExceptionHandler({CustomerNotFoundException.class})
    public String handleException() {
        return "bad_request";
    }

}
