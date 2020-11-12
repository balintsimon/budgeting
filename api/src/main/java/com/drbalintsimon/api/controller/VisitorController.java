package com.drbalintsimon.api.controller;

import com.drbalintsimon.api.model.Visitor;
import com.drbalintsimon.api.model.dto.VisitorCredentialsDTO;
import com.drbalintsimon.api.service.VisitorService;
import com.drbalintsimon.api.service.dao.VisitorDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RequiredArgsConstructor
@RestController
@Slf4j
public class VisitorController {
    private final VisitorDAO visitorDAO;
    private final VisitorService visitorService;

    @GetMapping("/user")
    public List<Visitor> getAllUsers() {
        log.info("Get all users");
        return visitorDAO.findAll();
    }

    @PostMapping("/user")
    public ResponseEntity saveNewUser(@RequestBody VisitorCredentialsDTO credentialsDTO) {
        log.info("Add new user");
        return visitorService.tryRegister(credentialsDTO);
    }
}
