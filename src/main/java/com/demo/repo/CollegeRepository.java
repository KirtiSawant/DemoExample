package com.demo.repo;

import com.demo.entity.College;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeRepository extends PagingAndSortingRepository<College,Integer> {

    Page<College> findByPlace(String place, Pageable paging);
}
