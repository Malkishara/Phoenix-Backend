package com.oxcentra.phoenix.service;


import com.oxcentra.phoenix.model.JobCategory;
import com.oxcentra.phoenix.repository.JobCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService{

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public List<JobCategory> getJobCategory(){
    return jobCategoryRepository.findAll();
    }
}
