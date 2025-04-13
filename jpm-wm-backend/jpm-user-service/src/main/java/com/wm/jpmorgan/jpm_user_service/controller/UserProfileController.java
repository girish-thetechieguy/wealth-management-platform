package com.wm.jpmorgan.jpm_user_service.controller;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.client.GraphQLError;
import com.netflix.graphql.dgs.exceptions.DgsBadRequestException;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.service.UserProfileService;
import com.wm.jpmorgan.jpm_user_service.exception.*;
import com.wm.jpmorgan.jpm_user_service.validation.UserProfileValidator;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.netflix.graphql.dgs.*;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

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
        return userProfileService.getUserById(id)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
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
        return userProfileService.updateUser(id, name, email, age, address)
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + id));
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
