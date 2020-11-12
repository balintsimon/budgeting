package com.drbalintsimon.api.service.dao;

import com.drbalintsimon.api.model.Visitor;
import com.drbalintsimon.api.model.dto.VisitorCredentialsDTO;

import java.util.List;

public interface VisitorDAO {
    List<Visitor> findAll();
    void save(VisitorCredentialsDTO credentialsDTO);
    boolean existsWithName(String name);
    boolean existsWithEmail(String email);
}
