package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.JobSeeker;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> getAllJobSeeker();
    String addJobSeeker(JobSeekerDto jobSeeker);
    Boolean updateJobSeeker(JobSeeker jobSeeker);
    JobSeeker getJobseekerById(Integer id);
    Boolean saveJobseeker();
    Boolean verifyUser(Integer code);
    Boolean sendVerificationCode();

    Boolean updatePassword(int userId, String userEmail, String password);

    List<JobSeeker> getAllJobSeekers();

    Boolean deleteJobSeekerById(Integer id);

    List<JobSeeker> getJobSeekersBySearchText(String title);
}