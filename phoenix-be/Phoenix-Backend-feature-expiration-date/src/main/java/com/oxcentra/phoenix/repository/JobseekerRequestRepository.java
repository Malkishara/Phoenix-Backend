package com.oxcentra.phoenix.repository;


import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.JobseekerRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JobseekerRequestRepository extends JpaRepository<JobseekerRequest,Integer> {

}
