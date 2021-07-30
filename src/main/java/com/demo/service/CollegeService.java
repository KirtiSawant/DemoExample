package com.demo.service;

import com.demo.entity.College;
import com.demo.repo.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeRepository collegeRepository;

    private Sort.Direction getSortDirection(String direction) {
        if (direction.equals("asc")) {
            return Sort.Direction.ASC;
        } else if (direction.equals("desc")) {
            return Sort.Direction.DESC;
        }

        return Sort.Direction.ASC;
    }

    public College createClg(College college) {
        return this.collegeRepository.save(college);
    }

    public List<College> search( String collegeName, String place,Integer pageNo, Integer pageSize) {
       // List<College> findByCollegeNameOrderByCollegeNameAscplaceDesc(String collegeName)
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<College> pageResult;
        if (collegeName == null && place ==null)
            pageResult = collegeRepository.findAll(paging);
        else
            pageResult = collegeRepository.findByCollegeNameAndPlace(collegeName,place,paging);

        if (pageResult.hasContent()) {
            return  pageResult.getContent();
        } else {
            return new ArrayList<College>();
        }
    }

    }