package com.jpmorgan.wm.jpm_advisory_service.exception;

public class DuplicateEmailException extends RuntimeException {
    public DuplicateEmailException(String email) {
        super("Email '" + email + "' is already in use by another advisor");
    }

    public DuplicateEmailException(String message, Throwable cause) {
        super(message, cause);
    }
}