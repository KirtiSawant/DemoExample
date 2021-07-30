package com.demo.repo;

import com.demo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,Integer> {

    Page<Employee> findByFirstName(String firstName, Pageable paging);

    Page<Employee> findByFirstNameAndLastName(String firstName, String lastName, Pageable paging);
}
