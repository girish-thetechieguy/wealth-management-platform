package com.jpmorgan.wm.kc_auth_service.repository;

import com.jpmorgan.wm.kc_auth_service.entity.AuthAuditLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthAuditLogRepository extends JpaRepository<AuthAuditLog, Long> {}
