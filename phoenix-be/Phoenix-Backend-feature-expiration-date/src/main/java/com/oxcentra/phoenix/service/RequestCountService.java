package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.RequestCount;

import java.util.List;
import java.util.Optional;

public interface RequestCountService {



    Boolean updateRequestCount(Integer id);

    void deleteRequest(Integer vacancy);

    void decreaseCountByVacancyId(List<JobseekerRequest> requestByJobSeekerId);
}
