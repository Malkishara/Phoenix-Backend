package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Integer> {
}
