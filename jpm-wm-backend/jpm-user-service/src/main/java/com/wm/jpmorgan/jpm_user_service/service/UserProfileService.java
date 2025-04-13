package com.wm.jpmorgan.jpm_user_service.service;

import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.repository.UserProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@RequiredArgsConstructor
@Validated
public class UserProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    public List<UserProfile> getAllUsers() {
        return userProfileRepository.findAll();
    }

    public UserProfile getUserById(String id) {
        return userProfileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public UserProfile createUser(String name, String email, int age, String address) {
        UserProfile user = new UserProfile(null, name, email, age, address);
        return userProfileRepository.save(user);
    }

    public UserProfile updateUser(String id, String name, String email, Integer age, String address) {
        UserProfile user = getUserById(id);
        if (name != null) user.setName(name);
        if (email != null) user.setEmail(email);
        if (age != null) user.setAge(age);
        if (address != null) user.setAddress(address);
        return userProfileRepository.save(user);
    }

    public boolean deleteUser(String id) {
        userProfileRepository.deleteById(id);
        return true;
    }
}