package com.oxcentra.phoenix.service;


import com.oxcentra.phoenix.model.JobCategory;
import com.oxcentra.phoenix.repository.JobCategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class JobCategoryServiceImpl implements JobCategoryService{

    @Autowired
    private JobCategoryRepository jobCategoryRepository;

    public List<JobCategory> getJobCategory(){
    return jobCategoryRepository.findAll();
    }

    @Override
    public Boolean addCategory(JobCategory jobCategory) {
        log.info("add category "+jobCategory.getTitle());
        jobCategoryRepository.save(jobCategory);
        return true;
    }

    @Override
    public Boolean updateCategory(JobCategory jobCategory) {
        log.info("update category "+jobCategory.getTitle());
        jobCategoryRepository.save(jobCategory);
        return true;
    }

    @Override
    public Boolean deleteCategoryById(String id) {
        log.info("delete category "+id);
        jobCategoryRepository.deleteById(id);
        return true;
    }
}
