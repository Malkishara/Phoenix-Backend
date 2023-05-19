package com.oxcentra.phoenix.repository;


import com.oxcentra.phoenix.model.JobModalities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobModalitiesRepository extends JpaRepository<JobModalities,String> {

}
