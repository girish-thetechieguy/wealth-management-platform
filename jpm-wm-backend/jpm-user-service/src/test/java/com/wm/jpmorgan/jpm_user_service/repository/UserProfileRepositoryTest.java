package com.wm.jpmorgan.jpm_user_service.repository;

import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import java.util.Optional;
import static org.assertj.core.api.Assertions.*;

@DataMongoTest
class UserProfileRepositoryTest {
    @Autowired
    private UserProfileRepository repository;

    // Store the ID of the test record for cleanup
    private String testRecordId;

    @AfterEach
    void cleanTestData() {
        // Delete only the test record we created
        if (testRecordId != null) {
            repository.deleteById(testRecordId);
        }
    }

    @Test
    void testFindByEmail() {
        // 1. Create test data
        UserProfile user = new UserProfile(null, "Alice", "alice@test.com", 25, "LA");
        UserProfile savedUser = repository.save(user);
        testRecordId = savedUser.getId(); // Store for cleanup

        // 2. Query the data
        Optional<UserProfile> found = repository.findByEmail("alice@test.com");

        // 3. Verify
        assertThat(found)
                .isPresent()
                .hasValueSatisfying(u -> {
                    assertThat(u.getName()).isEqualTo("Alice");
                    assertThat(u.getEmail()).isEqualTo("alice@test.com");
                });
    }

    @Test
    void testFindByEmail_NotFound() {
        // This test doesn't create data, so no cleanup needed
        Optional<UserProfile> found = repository.findByEmail("nonexistent@test.com");
        assertThat(found).isEmpty();
    }
}