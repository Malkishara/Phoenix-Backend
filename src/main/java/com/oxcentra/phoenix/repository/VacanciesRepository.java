package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.Vacancies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacanciesRepository extends JpaRepository<Vacancies,String> {
}
