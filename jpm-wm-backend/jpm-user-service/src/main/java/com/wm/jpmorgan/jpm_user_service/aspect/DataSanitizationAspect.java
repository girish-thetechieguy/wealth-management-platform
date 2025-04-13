package com.wm.jpmorgan.jpm_user_service.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
public class DataSanitizationAspect {
    @Before("execution(* com.wm.jpmorgan.jpm_user_service.controller.*.*(..))")
    public void sanitizeInput() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // Sanitize all request parameters
        request.getParameterMap().forEach((key, values) -> {
            String[] sanitizedValues = Arrays.stream(values)
                    .map(value -> Jsoup.clean(value, Safelist.basic()))
                    .toArray(String[]::new);
            request.setAttribute("sanitized_" + key, sanitizedValues);
        });
    }
}
