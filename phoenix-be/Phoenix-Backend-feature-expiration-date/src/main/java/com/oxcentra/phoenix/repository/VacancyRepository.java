package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {

    @Modifying
    @Query("DELETE FROM Vacancy e WHERE e.employer = ?1")
    void deleteByEmployer(Integer employer);
}
