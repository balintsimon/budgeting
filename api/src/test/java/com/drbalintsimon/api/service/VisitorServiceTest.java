package com.drbalintsimon.api.service;

import com.drbalintsimon.api.model.dto.VisitorCredentialsDTO;
import com.drbalintsimon.api.service.dao.VisitorDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class VisitorServiceTest {
    @MockBean
    private VisitorDAO visitorDao;

    @Autowired
    private VisitorService service;

    @Test
    public void smokeTest() {
        assertThat(service).isNotNull();
        assertThat(visitorDao).isNotNull();
    }

    @Test
    public void testSuccessfulRegistration() {
        String email = "donald@rumsfeld.com";
        String name = "Rumsfeld";
        String password = "password";
        String message = "Registration is successful";
        boolean isRegistrationSuccessful = true;
        VisitorCredentialsDTO newVisitor = new VisitorCredentialsDTO().builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        ResponseEntity expected = service.registrationMessage(message, isRegistrationSuccessful);
        given(visitorDao.existsWithEmail(email)).willReturn(false);
        given(visitorDao.existsWithName(name)).willReturn(false);
        ResponseEntity actual = service.tryRegister(newVisitor);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testEmailTakenRegistration() {
        String email = "donald@rumsfeld.com";
        String name = "Rumsfeld";
        String password = "password";
        String message = "Email " + email + " already taken!";
        boolean isRegistrationSuccessful = false;
        VisitorCredentialsDTO newVisitor = new VisitorCredentialsDTO().builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        ResponseEntity expected = service.registrationMessage(message, isRegistrationSuccessful);
        given(visitorDao.existsWithEmail(email)).willReturn(true);
        given(visitorDao.existsWithName(name)).willReturn(false);
        ResponseEntity actual = service.tryRegister(newVisitor);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void testUsernameTakenRegistration() {
        String email = "donald@rumsfeld.com";
        String name = "Rumsfeld";
        String password = "password";
        String message = "Username " + name + " already taken!";
        boolean isRegistrationSuccessful = false;
        VisitorCredentialsDTO newVisitor = new VisitorCredentialsDTO().builder()
                .name(name)
                .email(email)
                .password(password)
                .build();

        ResponseEntity expected = service.registrationMessage(message, isRegistrationSuccessful);
        given(visitorDao.existsWithEmail(email)).willReturn(false);
        given(visitorDao.existsWithName(name)).willReturn(true);
        ResponseEntity actual = service.tryRegister(newVisitor);

        assertThat(actual).isEqualTo(expected);
    }
}