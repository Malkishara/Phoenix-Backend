package com.oxcentra.phoenix.controller;

import com.oxcentra.phoenix.model.JobCategory;
import com.oxcentra.phoenix.service.JobCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class JobCategoryController {

    @Autowired
    private JobCategoryService jobCategoryService;

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/categories")
    public @ResponseBody List<JobCategory> getJobCategory(){
    return jobCategoryService.getJobCategory();
}
}
