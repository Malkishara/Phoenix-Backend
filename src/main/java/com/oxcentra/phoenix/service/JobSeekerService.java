package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.JobSeeker;

import java.util.List;
import java.util.Optional;

public interface JobSeekerService {

    List<JobSeeker> getAllJobSeeker();
    String addJobSeeker(JobSeekerDto jobSeekerDto);
    Boolean updateJobSeeker(JobSeeker jobSeeker);
    Optional<JobSeeker> getJobseekerById(Integer id);
}
