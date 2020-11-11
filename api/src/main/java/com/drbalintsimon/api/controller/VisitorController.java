package com.drbalintsimon.api.controller;

import com.drbalintsimon.api.model.Visitor;
import com.drbalintsimon.api.repository.UserRepository;
import com.drbalintsimon.api.serice.dao.VisitorDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@CrossOrigin
@RequiredArgsConstructor
@RestController
@Slf4j
public class VisitorController {
    private final VisitorDAO visitorDAO;
    private final UserRepository repository;

    @GetMapping("/user")
    public List<Visitor> getAllUsers() {
        System.out.println("Get all users");
        return visitorDAO.findAll();
    }

    @PostMapping("/user")
    public void saveNewUser() {
        System.out.println("Add new user");
//        BudgetingUser newBudgetingUser = BudgetingUser.builder().id(1L).name("BB King").password("whatnot").email("new@new.hu").build();
        Visitor newVisitor = Visitor.builder().name("BB King").password("whatnot").email("new@new.hu").build();
        System.out.println(newVisitor);
        repository.save(newVisitor);
    }
}
