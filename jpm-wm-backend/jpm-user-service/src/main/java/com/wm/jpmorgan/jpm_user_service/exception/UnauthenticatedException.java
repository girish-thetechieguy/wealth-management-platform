package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class UnauthenticatedException extends BaseApiException {
    public UnauthenticatedException(String message) {
        super(message, HttpStatus.UNAUTHORIZED);
    }
}
