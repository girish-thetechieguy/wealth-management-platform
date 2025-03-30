package com.jpmorgan.wm.jpm_client_service.repository;

import com.jpmorgan.wm.jpm_client_service.entity.ClientRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientRecord, Long> {
}
