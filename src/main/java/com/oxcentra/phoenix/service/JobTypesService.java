package com.oxcentra.phoenix.service;

import com.oxcentra.phoenix.model.JobTypes;

import java.util.List;

public interface JobTypesService {
    List<JobTypes> getAllJobTypes();

    Boolean deleteTypeById(String id);

    Boolean updateType(JobTypes jobTypes);

    Boolean addType(JobTypes jobTypes);
}
