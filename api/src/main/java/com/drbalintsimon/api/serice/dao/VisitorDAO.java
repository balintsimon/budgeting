package com.drbalintsimon.api.serice.dao;

import com.drbalintsimon.api.model.Visitor;

import java.util.List;

public interface VisitorDAO {
    List<Visitor> findAll();
}
