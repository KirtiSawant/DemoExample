package com.demo.repo;

import com.demo.entity.College;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollegeRepository extends PagingAndSortingRepository<College,Integer> {

    Page<College> findByCollegeNameAndPlace(String collegeName,String place, Pageable paging);
}
