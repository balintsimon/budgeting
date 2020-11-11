package com.drbalintsimon.api.repository;

import com.drbalintsimon.api.model.Spenditure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpenditureRepository extends JpaRepository<Spenditure, Long> {
    List<Spenditure> findAll();
}
