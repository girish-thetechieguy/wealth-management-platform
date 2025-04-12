package com.wm.jpmorgan.jpm_user_service.repository;

import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    Optional<UserProfile> findByEmail(String email);
}