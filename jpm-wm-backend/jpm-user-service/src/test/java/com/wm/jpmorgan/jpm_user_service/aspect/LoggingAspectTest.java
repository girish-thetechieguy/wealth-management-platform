package com.wm.jpmorgan.jpm_user_service.aspect;

import org.aspectj.lang.Signature;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest // Full context loading
@EnableAspectJAutoProxy
class LoggingAspectTest {
    @Mock
    private Logger logger;

    @Mock
    private JoinPoint joinPoint;

    @Mock
    private Signature signature;

    @InjectMocks
    private LoggingAspect loggingAspect;

    @Test
    void logAfterControllerMethods_ShouldLogMethodAndResult() {
        // Arrange
        Object mockResult = "Success";
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("getAllUsers");

        // Act
        loggingAspect.logAfterControllerMethods(joinPoint, mockResult);

        // Assert
        verify(logger).info("Method: getAllUsers | Result: Success");
    }

    @Test
    void logAfterControllerMethods_ShouldHandleNullResult() {
        // Arrange
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("deleteUser");

        // Act
        loggingAspect.logAfterControllerMethods(joinPoint, null);

        // Assert
        verify(logger).info("Method: deleteUser | Result: null");
    }

    @Test
    void logBeforeServiceMethods_ShouldLogMethodName() {
        // Arrange
        when(joinPoint.getSignature()).thenReturn(signature);
        when(signature.getName()).thenReturn("createUser");

        // Act
        loggingAspect.logBeforeServiceMethods(joinPoint);

        // Assert
        verify(logger).info("Executing: createUser");
    }
}