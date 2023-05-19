package com.oxcentra.phoenix.repository;

import com.oxcentra.phoenix.model.RequestCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCountRepository extends JpaRepository<RequestCount,Integer> {
}
