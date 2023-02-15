package com.oxcentra.phoenix.repository;


import com.oxcentra.phoenix.model.Companies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompaniesRepository extends JpaRepository<Companies,String> {

}
