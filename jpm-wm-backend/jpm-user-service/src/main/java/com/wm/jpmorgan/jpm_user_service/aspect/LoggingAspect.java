package com.wm.jpmorgan.jpm_user_service.aspect;

import com.wm.jpmorgan.jpm_user_service.constant.UserServiceConstants;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {
    @Before("execution(* com.wm.jpmorgan.jpm_user_service.service.*.*(..))")
    public void logBeforeServiceMethods(JoinPoint joinPoint) {
        log.info(UserServiceConstants.EXECUTING, joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "execution(* com.wm.jpmorgan.jpm_user_service.controller.*.*(..))", returning = "result")
    public void logAfterControllerMethods(JoinPoint joinPoint, Object result) {
        log.info(UserServiceConstants.METHOD_RESULT, joinPoint.getSignature().getName(), result);
    }
}
