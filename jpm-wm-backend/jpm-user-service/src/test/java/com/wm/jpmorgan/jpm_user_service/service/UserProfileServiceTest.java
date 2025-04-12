package com.wm.jpmorgan.jpm_user_service.service;

import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import com.wm.jpmorgan.jpm_user_service.repository.UserProfileRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserProfileServiceTest {
    @Mock
    private UserProfileRepository repository;
    @InjectMocks
    private UserProfileService service;

    @Test
    void testGetUserById_Found() {
        UserProfile user = new UserProfile("1", "John", "john@test.com", 30, "NY");
        when(repository.findById("1")).thenReturn(Optional.of(user));

        UserProfile result = service.getUserById("1");
        assertThat(result.getName()).isEqualTo("John");
        verify(repository, times(1)).findById("1");
    }

    @Test
    void testGetUserById_NotFound() {
        when(repository.findById("99")).thenReturn(Optional.empty());
        assertThatThrownBy(() -> service.getUserById("99"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("User not found");
    }

    @Test
    void testUpdateUser() {
        UserProfile existing = new UserProfile("1", "Old", "old@test.com", 20, "OldCity");
        when(repository.findById("1")).thenReturn(Optional.of(existing));
        when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));

        UserProfile updated = service.updateUser("1", "New", null, 30, null);

        assertThat(updated.getName()).isEqualTo("New");
        assertThat(updated.getEmail()).isEqualTo("old@test.com"); // Unchanged
        assertThat(updated.getAge()).isEqualTo(30);
        verify(repository, times(1)).save(existing);
    }

    @Test
    void testDeleteUser() {
        doNothing().when(repository).deleteById("1");
        boolean result = service.deleteUser("1");
        assertThat(result).isTrue();
        verify(repository, times(1)).deleteById("1");
    }
}