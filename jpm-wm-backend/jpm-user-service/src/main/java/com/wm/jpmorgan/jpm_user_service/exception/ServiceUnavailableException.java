package com.wm.jpmorgan.jpm_user_service.exception;

import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends BaseApiException {
    public ServiceUnavailableException(String message) {
        super(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
