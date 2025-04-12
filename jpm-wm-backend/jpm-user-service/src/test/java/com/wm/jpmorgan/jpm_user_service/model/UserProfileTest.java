package com.wm.jpmorgan.jpm_user_service.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class UserProfileTest {
    @Test
    void testUserProfileEntity() {
        UserProfile user = new UserProfile("1", "John", "john@test.com", 30, "NY");

        assertThat(user.getId()).isEqualTo("1");
        assertThat(user.getName()).isEqualTo("John");
        assertThat(user.getEmail()).isEqualTo("john@test.com");
        assertThat(user.getAge()).isEqualTo(30);
        assertThat(user.getAddress()).isEqualTo("NY");

        // Test Lombok's @Data (equals, hashCode, toString)
        UserProfile sameUser = new UserProfile("1", "John", "john@test.com", 30, "NY");
        assertThat(user).isEqualTo(sameUser);
        assertThat(user.hashCode()).isEqualTo(sameUser.hashCode());
        assertThat(user.toString()).contains("John");
    }
}