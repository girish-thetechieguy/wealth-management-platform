package com.jpmorgan.wm.kc_auth_service.controller;

import com.jpmorgan.wm.kc_auth_service.entity.LoginRequest;
import com.jpmorgan.wm.kc_auth_service.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(
            @RequestBody LoginRequest request,
            @RequestHeader("X-Forwarded-For") String ipAddress) {

        var result = authService.authenticate(
                request.getUsername(),
                request.getPassword(),
                ipAddress
        );

        if (result.success()) {
            return ResponseEntity.ok(Map.of(
                    "status", "success",
                    "user", result.user()
            ));
        } else {
            return ResponseEntity.status(401).body(Map.of(
                    "status", "error",
                    "message", result.message()
            ));
        }
    }
}
