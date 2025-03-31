package com.jpmorgan.wm.jpm_advisory_service.repository;

import com.jpmorgan.wm.jpm_advisory_service.model.Advisor;
import com.jpmorgan.wm.jpm_advisory_service.model.AdvisorStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
    List<Advisor> findByStatus(AdvisorStatus status);
    boolean existsByEmail(String email);
}
