package com.ust.student_management_api.exceptions;

public class RegisterNumberAlreadyExistsException extends Exception {
    public RegisterNumberAlreadyExistsException(String message) {
        super(message);
    }
}
