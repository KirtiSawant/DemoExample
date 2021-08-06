package com.demo.service;

import com.demo.entity.College;
import com.demo.repo.CollegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public List<College> search(String place, Integer pageNo, Integer pageSize, String[] sort) {
        List<Sort.Order> orders = new ArrayList<Sort.Order>();
        if (sort[0].contains(",")) {
            for (String sortOrder : sort) {
                String[] _sort = sortOrder.split(",");
                orders.add(new Sort.Order(getSortDirection(_sort[1]), _sort[0]));
            }
        } else {
            orders.add(new Sort.Order(getSortDirection(sort[1]), sort[0]));
        }
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(orders));
        Page<College> pageResult;
        if (place == null)
            pageResult = collegeRepository.findAll(paging);
        else
            pageResult = collegeRepository.findByPlace(place, paging);

        if (pageResult.hasContent()) {
            return pageResult.getContent();
        } else {
            return new ArrayList<College>();
        }
    }

    }