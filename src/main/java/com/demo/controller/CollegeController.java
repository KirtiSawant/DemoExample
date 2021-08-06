package com.demo.controller;

import com.demo.entity.College;
import com.demo.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("college")
    public College createClg(@Valid @RequestBody College college) {
        return this.collegeService.createClg(college);
    }

    @GetMapping("college")
    public ResponseEntity<List<College>> search(
            @RequestParam(value = "place") String place,
            @RequestParam(defaultValue = "0", required = false) Integer pageNo,
            @RequestParam(defaultValue = "5", required = false) Integer pageSize,
            @RequestParam(required = false) String[] sort) {
        List<College> list = (List<College>) collegeService.search(place, pageNo, pageSize, sort);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
