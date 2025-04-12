package com.wm.jpmorgan.jpm_user_service.controller;

import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.service.UserProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserProfileControllerTest {
    @Mock
    private UserProfileService userProfileService;
    @InjectMocks
    private UserProfileController userProfileController;

    @Test
    void testGetAllUsers() {
        // Setup
        UserProfile user = new UserProfile("1", "John", "john@test.com", 30, "NY");
        when(userProfileService.getAllUsers()).thenReturn(Collections.singletonList(user));

        // Execute
        List<UserProfile> result = userProfileController.getAllUsers();

        // Verify
        assertEquals(1, result.size());
        assertEquals("John", result.get(0).getName());
        verify(userProfileService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() {
        // Setup
        UserProfile user = new UserProfile("1", "John", "john@test.com", 30, "NY");
        when(userProfileService.getUserById("1")).thenReturn(user);

        // Execute
        UserProfile result = userProfileController.getUserById("1");

        // Verify
        assertEquals("John", result.getName());
        verify(userProfileService, times(1)).getUserById("1");
    }

    @Test
    void testCreateUser() {
        // Setup
        UserProfile newUser = new UserProfile("1", "Alice", "alice@test.com", 25, "LA");
        when(userProfileService.createUser("Alice", "alice@test.com", 25, "LA"))
                .thenReturn(newUser);

        // Execute
        UserProfile result = userProfileController.createUser(
                "Alice", "alice@test.com", 25, "LA");

        // Verify
        assertEquals("1", result.getId());
        verify(userProfileService, times(1))
                .createUser("Alice", "alice@test.com", 25, "LA");
    }

    @Test
    void testUpdateUser() {
        // Setup
        UserProfile updatedUser = new UserProfile("1", "John Updated", "john@test.com", 31, "NY");
        when(userProfileService.updateUser("1", "John Updated", null, 31, null))
                .thenReturn(updatedUser);

        // Execute
        UserProfile result = userProfileController.updateUser(
                "1", "John Updated", null, 31, null);

        // Verify
        assertEquals("John Updated", result.getName());
        assertEquals(31, result.getAge());
        verify(userProfileService, times(1))
                .updateUser("1", "John Updated", null, 31, null);
    }

    @Test
    void testDeleteUser() {
        // Setup
        when(userProfileService.deleteUser("1")).thenReturn(true);

        // Execute
        boolean result = userProfileController.deleteUser("1");

        // Verify
        assertTrue(result);
        verify(userProfileService, times(1)).deleteUser("1");
    }
}