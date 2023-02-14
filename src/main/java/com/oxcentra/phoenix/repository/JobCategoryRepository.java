package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.JobCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobCategoryRepository extends JpaRepository<JobCategory,String> {

}
