package com.wm.jpmorgan.jpm_user_service.aspect;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Aspect
@Component
public class JwtAuthAspect {

    private final String SECRET_KEY = "My-256-bit-secret";

    @Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void authenticate() {
        HttpServletRequest request = getCurrentRequest();
        String token = extractToken(request);
        validateToken(token);
    }

    private HttpServletRequest getCurrentRequest() {
        return ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || !header.startsWith("Bearer ")) {
            throw new SecurityException("Missing or invalid Authorization header");
        }
        return header.substring(7);
    }

    private void validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes(StandardCharsets.UTF_8)))
                    .build()
                    .parseClaimsJws(token);
        } catch (Exception ex) {
            throw new SecurityException("Invalid token");
        }
    }
}
