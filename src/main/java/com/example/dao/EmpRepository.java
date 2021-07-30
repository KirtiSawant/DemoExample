package com.example.dao;

import com.example.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends CrudRepository<Employee,Integer> {
}
