package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.JobTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobTypesRepository extends JpaRepository<JobTypes,String> {
}
