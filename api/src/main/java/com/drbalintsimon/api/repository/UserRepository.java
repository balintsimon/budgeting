package com.drbalintsimon.api.repository;

import com.drbalintsimon.api.model.Visitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Visitor, Long> {
    List<Visitor> findAll();
}
