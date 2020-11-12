package com.drbalintsimon.api.repository;

import com.drbalintsimon.api.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findAll();
    Optional<Visitor> findByName(String name);
    Optional<Visitor> findByEmail(String email);
}
