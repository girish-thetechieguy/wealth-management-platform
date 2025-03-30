package com.jpmorgan.wm.kc_auth_service.service;

import com.jpmorgan.wm.kc_auth_service.entity.AuthAuditLog;
import com.jpmorgan.wm.kc_auth_service.repository.AuthAuditLogRepository;
import com.jpmorgan.wm.kc_auth_service.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthRepository authRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthAuditLogRepository auditLogRepo;


    @Autowired
    public AuthService(AuthRepository authRepository, PasswordEncoder passwordEncoder, AuthAuditLogRepository auditLogRepo) {
        this.authRepository = authRepository;
        this.passwordEncoder = passwordEncoder;
        this.auditLogRepo = auditLogRepo;
    }


    public boolean authenticate(String username, String password) {
        return authRepository.findByUsername(username)
                .map(client -> passwordEncoder.matches(password, client.getPassword()))
                .orElse(false);
    }

    @Transactional
    public AuthResult authenticate(String username, String password, String ipAddress) {
        var user = userRepo.findByUsername(username);

        if (user.isEmpty()) {
            logFailure(username, ipAddress, "USER_NOT_FOUND");
            return AuthResult.failure("Invalid credentials");
        }

        if (!passwordEncoder.matches(password, user.get().getPassword())) {
            logFailure(username, ipAddress, "INVALID_PASSWORD");
            return AuthResult.failure("Invalid credentials");
        }

        logSuccess(username, ipAddress);
        return AuthResult.success(user.get());
    }

    private void logSuccess(String username, String ipAddress) {
        auditLogRepo.save(new AuthAuditLog(
                null, username, ipAddress, LocalDateTime.now(), true, null
        ));
    }

    private void logFailure(String username, String ipAddress, String reason) {
        auditLogRepo.save(new AuthAuditLog(
                null, username, ipAddress, LocalDateTime.now(), false, reason
        ));
    }

    public record AuthResult(boolean success, String message, User user) {
        public static AuthResult success(User user) {
            return new AuthResult(true, "Authentication successful", user);
        }
        public static AuthResult failure(String message) {
            return new AuthResult(false, message, null);
        }
    }
}
