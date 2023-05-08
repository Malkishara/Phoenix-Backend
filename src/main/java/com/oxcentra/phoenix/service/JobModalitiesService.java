package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobModalities;


import java.util.List;

public interface JobModalitiesService {
    List<JobModalities> getAllJobModalities();

    Boolean addModality(JobModalities jobModalities);

    Boolean updateModality(JobModalities jobModalities);

    Boolean deleteModalityById(String id);
}
