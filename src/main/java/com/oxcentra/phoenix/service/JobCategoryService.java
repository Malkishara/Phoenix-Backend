package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobCategory;

import java.util.List;

public interface JobCategoryService {
    List<JobCategory> getJobCategory();

    Boolean addCategory(JobCategory jobCategory);

    Boolean updateCategory(JobCategory jobCategory);

    Boolean deleteCategoryById(String id);
}
