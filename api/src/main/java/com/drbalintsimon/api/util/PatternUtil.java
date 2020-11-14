package com.drbalintsimon.api.util;

import org.springframework.stereotype.Service;

@Service
public class PatternUtil {

    public static boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+[.]+[a-zA-Z0-9.-]+$");
    }
}
