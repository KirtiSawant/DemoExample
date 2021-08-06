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

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    public Employee createEmployee(Employee employee) {
        return (Employee) this.employeeRepository.save(employee);
    }


    public List<Employee> getEmp() {

        List<Employee> employees = (List<Employee>) employeeRepository.findAll();
        System.out.println("Getting data from DB :" + employees);
        return employees;
    }

    public Employee getEmpById(int id) {
        return employeeRepository.findById(id).get();
    }

    public List<Employee> getAllEmp(String firstName, Integer page, Integer size, String[] sortBy) {
    /*    Sort sortOrder = Sort.by("age");
        List<Employee> list = (List<Employee>) employeeRepository.findAll(sortOrder);
        if (list.isEmpty()) {
            return list;
        }*/
        List<Sort.Order> orders = new ArrayList<Sort.Order>();

        if (sortBy[0].contains(",")) {
            // will sort more than 2 fields
            // sortOrder="field, direction"
            for (String sortOrder : sortBy) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            // sort=[field, direction]
            orders.add(new Sort.Order(getSortDirection(sortBy[1]), sortBy[0]));
        }
        Pageable paging = PageRequest.of(page, size, Sort.by(orders));
        Page<Employee> pageResult;
        if (firstName == null)
            pageResult = employeeRepository.findAll(paging);
        else
            pageResult = employeeRepository.findByFirstName(firstName, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
    }
}
