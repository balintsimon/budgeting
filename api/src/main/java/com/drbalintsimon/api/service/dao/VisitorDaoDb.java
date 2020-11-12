package com.drbalintsimon.api.service.dao;

import com.drbalintsimon.api.model.Visitor;
import com.drbalintsimon.api.model.dto.VisitorCredentialsDTO;
import com.drbalintsimon.api.repository.VisitorRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@RequiredArgsConstructor
public class VisitorDaoDb implements VisitorDAO {
    private final VisitorRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<Visitor> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(VisitorCredentialsDTO credentialsDTO) {
        Visitor visitor = Visitor.builder()
                .name(credentialsDTO.getName())
                .email(credentialsDTO.getEmail())
                .password(passwordEncoder.encode(credentialsDTO.getPassword()))
                .build();
        repository.save(visitor);
    }

    @Override
    public boolean existsWithName(String name) {
        return repository.findByName(name).isPresent();
    }

    @Override
    public boolean existsWithEmail(String email) {
        return repository.findByEmail(email).isPresent();
    }
}
