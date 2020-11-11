package com.drbalintsimon.api.serice;

import com.drbalintsimon.api.model.Visitor;
import com.drbalintsimon.api.repository.UserRepository;
import com.drbalintsimon.api.serice.dao.VisitorDAO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class VisitorDaoDb implements VisitorDAO {
    private final UserRepository repository;

    @Override
    public List<Visitor> findAll() {
        return repository.findAll();
    }
}
