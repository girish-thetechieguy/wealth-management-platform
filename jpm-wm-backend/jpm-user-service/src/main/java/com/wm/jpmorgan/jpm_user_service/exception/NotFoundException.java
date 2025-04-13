package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseApiException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
