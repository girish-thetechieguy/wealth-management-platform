package com.wm.jpmorgan.jpm_user_service.controller;

import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.service.UserProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

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
}
