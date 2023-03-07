package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.dto.JobSeekerDto;
import com.oxcentra.phoenix.model.JobSeeker;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> getAllJobSeeker();
    String addJobSeeker(JobSeekerDto jobSeekerDto);
}
