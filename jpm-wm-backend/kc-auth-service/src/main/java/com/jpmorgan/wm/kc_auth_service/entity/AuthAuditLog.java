package com.jpmorgan.wm.kc_auth_service.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "auth_audit_log")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthAuditLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String ipAddress;
    private LocalDateTime timestamp;
    private boolean success;
    private String failureReason;
}

