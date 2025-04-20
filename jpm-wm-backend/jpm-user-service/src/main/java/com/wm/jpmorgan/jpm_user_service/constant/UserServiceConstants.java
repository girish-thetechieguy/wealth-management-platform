package com.wm.jpmorgan.jpm_user_service.constant;

public interface  UserServiceConstants {

    // Aspects
    public static final String SANITIZED = "sanitized_";
    public static final String SECRET_KEY = "My-256-bit-secret";
    public static final String AUTHORIZATION = "Authorization";
    public static final String BEARER = "Bearer ";
    public static final String MISSING_HEADER_ERROR = "Missing or invalid Authorization header";
    public static final String INVALID_TOKEN = "Invalid token";
    public static final String EXECUTING = "Executing: {}";
    public static final String METHOD_RESULT = "Method: {} | Result: {}";

    // Config

    // Constants

    // Controllers
    public static final String FAILED_FETCH_USER = "Failed to fetch users: ";
    public static final String USER_NOT_FOUND = "User not found with ID: ";

    // Exception

    // Model
    public static final String ID_BLANK_ERROR = "ID cannot be blank";
    public static final String INVALID_ID_FORMAT = "Invalid ID format";
    public static final String NAME_CANNOT_BLANK = "Name cannot be blank";
    public static final String NAME_LIMIT_ERROR = "Name must be between 2-50 characters";
    public static final String VALID_EMAIL_ERROR = "Email should be valid";
    public static final String BLANK_EMAIL_ERROR = "Email cannot be blank";
    public static final String AGE_MIN_LIMIT_ERROR = "Age must be at least 18";
    public static final String AGE_MAX_LIMIT_ERROR = "Age must be less than 120";
    public static final String ADDRESS_LIMIT_ERROR = "Address cannot exceed 200 characters";

    // Repository

    // Service

    // Validation




}
