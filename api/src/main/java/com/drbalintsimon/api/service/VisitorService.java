package com.drbalintsimon.api.service;

import com.drbalintsimon.api.model.dto.VisitorCredentialsDTO;
import com.drbalintsimon.api.service.dao.VisitorDAO;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Data
@RequiredArgsConstructor
@Service
@Slf4j
public class VisitorService {
    private final VisitorDAO visitorDao;

    public ResponseEntity tryRegister(VisitorCredentialsDTO credentialsDTO) {
        if (isRegistrationRequestInvalid(credentialsDTO)) {
            String missingDataMessage = "Invalid request";
            return registrationMessage(missingDataMessage, false);
        }
        if (visitorDao.existsWithName(credentialsDTO.getName())) {
            String usernameTakenMessage = "Username already taken!";
            return registrationMessage(usernameTakenMessage, false);
        }
        if (visitorDao.existsWithEmail(credentialsDTO.getEmail())) {
            String emailTakenMessage = "Email already taken!";
            return registrationMessage(emailTakenMessage, false);
        }
        visitorDao.save(credentialsDTO);
        String successMessage = "Registration is successful";
        return registrationMessage(successMessage, true);
    }

    private boolean isRegistrationRequestInvalid(VisitorCredentialsDTO credentialsDTO) {
        return credentialsDTO.getEmail() == null ||
                credentialsDTO.getName() == null ||
                credentialsDTO.getPassword() == null ||
                credentialsDTO.getEmail().isEmpty() ||
                credentialsDTO.getName().isEmpty() ||
                credentialsDTO.getPassword().isEmpty();
    }

    public ResponseEntity registrationMessage(String message, boolean isSuccessful) {
        Map<String, Object> responseMessage = new HashMap<>();
        responseMessage.put("success", isSuccessful);
        responseMessage.put("message", message);
        return ResponseEntity.ok(responseMessage);
    }
}
