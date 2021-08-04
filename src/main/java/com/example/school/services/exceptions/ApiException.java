package com.example.school.services.exceptions;

import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, HttpStatus status) {
        super(message);
    }
}
