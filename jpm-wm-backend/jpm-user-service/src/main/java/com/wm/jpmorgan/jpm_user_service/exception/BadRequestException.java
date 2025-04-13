package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseApiException {
    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}