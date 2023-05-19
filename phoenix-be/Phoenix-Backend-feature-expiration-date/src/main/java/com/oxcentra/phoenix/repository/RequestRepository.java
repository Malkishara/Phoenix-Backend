package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.JobSeeker;
import com.oxcentra.phoenix.model.JobseekerRequest;
import com.oxcentra.phoenix.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request,Integer> {
    @Modifying
    @Query("DELETE FROM Request j WHERE j.jobSeeker = ?1")
    void deleteByJobSeekerId(Integer jobSeeker);
}
