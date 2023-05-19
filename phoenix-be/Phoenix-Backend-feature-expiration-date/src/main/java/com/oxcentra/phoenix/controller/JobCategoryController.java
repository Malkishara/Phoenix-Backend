package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.Employer;
import com.oxcentra.phoenix.model.JobCategory;
import com.oxcentra.phoenix.service.JobCategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories")
    public @ResponseBody List<JobCategory> getJobCategory(){
    return jobCategoryService.getJobCategory();
}

    @DeleteMapping("/category/{id}")
    public @ResponseBody
    Boolean deleteCategoryById(@PathVariable String id) {
        log.info(id);
        return jobCategoryService.deleteCategoryById(id);
    }

    @PutMapping("/category/{id}")
    public @ResponseBody
    Boolean updateCategoryData(@RequestBody JobCategory jobCategory) {

        log.info(jobCategory.getTitle());
        return jobCategoryService.updateCategory(jobCategory);
    }

    @PostMapping("/category")
    public @ResponseBody
    Boolean addCategory(@RequestBody JobCategory jobCategory) {

        log.info(jobCategory.getTitle());
        return jobCategoryService.addCategory(jobCategory);
    }
}
