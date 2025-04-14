package com.wm.jpmorgan.jpm_user_service.controller;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.wm.jpmorgan.jpm_user_service.exception.NotFoundException;
import com.wm.jpmorgan.jpm_user_service.exception.ServiceUnavailableException;
import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.service.UserProfileService;
import com.wm.jpmorgan.jpm_user_service.validation.UserProfileValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
@RequiredArgsConstructor
public class UserProfileController {

    @Autowired
    private UserProfileService userProfileService;

    @Autowired
    private UserProfileValidator userProfileValidator;

    @DgsQuery
    public List<UserProfile> getAllUsers() {
        try {
            return userProfileService.getAllUsers();
        } catch (Exception e) {
            throw new ServiceUnavailableException("Failed to fetch users: " + e.getMessage());
        }
    }

    @DgsQuery
    public UserProfile getUserById(@InputArgument String id) {
        userProfileValidator.validateId(id);
        return userProfileService.getUserById(id); // Service already throws
    }


    @DgsMutation
    public UserProfile createUser(
            @InputArgument String name,
            @InputArgument String email,
            @InputArgument int age,
            @InputArgument String address) {
        userProfileValidator.validateCreate(name, email, age, address);
        return userProfileService.createUser(name, email, age, address);
    }

    @DgsMutation
    public UserProfile updateUser(
            @InputArgument String id,
            @InputArgument String name,
            @InputArgument String email,
            @InputArgument Integer age,
            @InputArgument String address) {
        userProfileValidator.validateUpdate(id, name, email, age, address);
        return userProfileService.updateUser(id, name, email, age, address);
    }

    @DgsMutation
    public Boolean deleteUser(@InputArgument String id) {
        userProfileValidator.validateId(id);
        if (!userProfileService.deleteUser(id)) {
            throw new NotFoundException("User not found with ID: " + id);
        }
        return true;
    }
}
