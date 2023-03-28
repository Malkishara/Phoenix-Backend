package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobseekerRequest;

import java.util.List;

public interface JobseekerRequestService {
    List<JobseekerRequest> getAllRequestByVacancyId(Integer id);

    Boolean addRequest(JobseekerRequest jobseekerRequest);
}
