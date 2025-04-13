package com.wm.jpmorgan.jpm_user_service.aspect;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.jsoup.Jsoup;
import org.jsoup.safety.Safelist;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;

@Aspect
@Component
@Slf4j
public class SanitizationAspect {
    @Before("@annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            "@annotation(org.springframework.web.bind.annotation.PutMapping)")
    public void sanitizeInput() {
        HttpServletRequest request = getCurrentRequest();

        request.getParameterMap().forEach((param, values) -> {
            String[] originalValues = values;
            String[] sanitizedValues = Arrays.stream(values)
                    .map(v -> Jsoup.clean(v, Safelist.basic()))
                    .toArray(String[]::new);

            // Log before/after for visibility
            log.info("Sanitized param '{}': {} → {}",
                    param,
                    Arrays.toString(originalValues),
                    Arrays.toString(sanitizedValues));

            request.setAttribute("sanitized_" + param, sanitizedValues);
        });
    }

    private HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }
}
