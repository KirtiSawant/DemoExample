package com.demo.controller;

import com.demo.entity.Branch;
import com.demo.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BranchController {

    @Autowired
    BranchService branchService;
    @PostMapping("branch")
    public Branch createBranch(@RequestBody Branch branch){
        return branchService.createBranch(branch);
    }
}
