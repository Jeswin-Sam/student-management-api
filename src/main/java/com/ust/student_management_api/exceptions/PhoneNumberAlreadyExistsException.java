package com.ust.student_management_api.exceptions;

public class PhoneNumberAlreadyExistsException extends Exception{
    public PhoneNumberAlreadyExistsException(String message) {
        super(message);
    }
}
