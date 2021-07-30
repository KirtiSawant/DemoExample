package com.demo.repo;

import com.demo.entity.Branch;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface BranchRepository extends CrudRepository<Branch,Integer> {

}
