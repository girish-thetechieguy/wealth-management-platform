package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class PermissionDeniedException extends BaseApiException {
    public PermissionDeniedException(String message) {
        super(message, HttpStatus.FORBIDDEN);
    }
}