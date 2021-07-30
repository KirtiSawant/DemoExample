package com.demo.service;

import com.demo.entity.Branch;
import com.demo.repo.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {
    @Autowired
    BranchRepository branchRepository;

    public Branch createBranch(Branch branch) {
        return branchRepository.save(branch);
    }
}
