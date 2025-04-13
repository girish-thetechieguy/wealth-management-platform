package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class FailedPreconditionException extends BaseApiException {
    public FailedPreconditionException(String message) {
        super(message, HttpStatus.PRECONDITION_FAILED);
    }
}