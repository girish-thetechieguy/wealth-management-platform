package com.jpmorgan.wm.jpm_advisory_service.exception;

public class AdvisorNotFoundException extends RuntimeException {
    public AdvisorNotFoundException(Long id) {
        super("Advisor not found with id: " + id);
    }

    public AdvisorNotFoundException(String message) {
        super(message);
    }
}