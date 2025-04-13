package com.wm.jpmorgan.jpm_user_service.aspect;

import com.netflix.graphql.dgs.exceptions.DefaultDgsGraphQLError;
import com.netflix.graphql.types.errors.ErrorType;
import com.netflix.graphql.types.errors.TypedGraphQLError;
import com.wm.jpmorgan.jpm_user_service.exception.BaseApiException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import graphql.GraphQLError;
import java.util.Map;

@ControllerAdvice
public class GlobalGraphQLErrorHandler {
    @ExceptionHandler(BaseApiException.class)
    public GraphQLError handleApiException(BaseApiException ex) {
        return TypedGraphQLError.newBuilder()
                .message(ex.getMessage())
                .errorType(convertToErrorType(ex.getStatus()))
                .path(null)
                .extensions(Map.of(
                        "statusCode", ex.getStatus().value(),
                        "classification", "BusinessError"
                ))
                .build();
    }

    @ExceptionHandler(Exception.class)
    public GraphQLError handleGenericException(Exception ex) {
        return new DefaultDgsGraphQLError(
                ex.getMessage(),
                null,
                null,
                ErrorType.INTERNAL,
                Map.of("statusCode", 500)
        );
    }

    private ErrorType convertToErrorType(HttpStatus status) {
        return switch (status) {
            case BAD_REQUEST -> ErrorType.BAD_REQUEST;
            case UNAUTHORIZED -> ErrorType.UNAUTHENTICATED;
            case FORBIDDEN -> ErrorType.PERMISSION_DENIED;
            case NOT_FOUND -> ErrorType.NOT_FOUND;
            case PRECONDITION_FAILED -> ErrorType.FAILED_PRECONDITION;
            case SERVICE_UNAVAILABLE -> ErrorType.UNAVAILABLE;
            default -> ErrorType.INTERNAL;
        };
    }
}
