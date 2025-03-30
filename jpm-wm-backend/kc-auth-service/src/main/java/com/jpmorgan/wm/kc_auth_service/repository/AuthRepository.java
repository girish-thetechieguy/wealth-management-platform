package com.jpmorgan.wm.kc_auth_service.repository;

import com.jpmorgan.wm.kc_auth_service.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);
}