package com.wm.jpmorgan.jpm_user_service.controller;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.netflix.graphql.dgs.exceptions.DgsBadRequestException;
import com.netflix.graphql.dgs.exceptions.DgsEntityNotFoundException;
import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.service.UserProfileService;
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

    @DgsQuery
    public List<UserProfile> getAllUsers() {
        return userProfileService.getAllUsers();
    }

    @DgsQuery
    public UserProfile getUserById(@InputArgument String id) {
        return userProfileService.getUserById(id);
    }


    @DgsMutation
    public UserProfile createUser(
            @InputArgument String name,
            @InputArgument String email,
            @InputArgument int age,
            @InputArgument String address) {
        return userProfileService.createUser(name, email, age, address);
    }

    @DgsMutation
    public UserProfile updateUser(
            @InputArgument String id,
            @InputArgument String name,
            @InputArgument String email,
            @InputArgument Integer age,
            @InputArgument String address) {
        return userProfileService.updateUser(id, name, email, age, address);
    }

    @DgsMutation
    public Boolean deleteUser(@InputArgument String id) {
        return userProfileService.deleteUser(id);
    }

    @DgsExceptionHandler
    public ResponseEntity<Map<String, Object>> handleException(Exception ex) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
        Map<String, Object> body = new LinkedHashMap<>();

        if (ex instanceof DgsEntityNotFoundException) {
            status = HttpStatus.NOT_FOUND;
            body.put("message", ex.getMessage());
        }
        else if (ex instanceof DgsBadRequestException) {
            status = HttpStatus.BAD_REQUEST;
            body.put("error", ex.getMessage());
        }
        else if (ex instanceof SecurityException) {
            status = HttpStatus.UNAUTHORIZED;
            body.put("error", "Authentication failed");
            body.put("details", ex.getMessage());
        }

        body.put("timestamp", new Date());
        body.put("status", status.value());

        return new ResponseEntity<>(body, status);
    }
}
