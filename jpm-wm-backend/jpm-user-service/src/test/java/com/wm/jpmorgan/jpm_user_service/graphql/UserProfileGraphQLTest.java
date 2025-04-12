package com.wm.jpmorgan.jpm_user_service.graphql;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureGraphQlTester
public class UserProfileGraphQLTest {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void testGetAllUsers_GraphQL() {
        // Language=GraphQL
        String query = """
        query {
            getAllUsers {
                id
                name
                email
            }
        }
        """;

        graphQlTester.document(query)
                .execute()
                .path("data.getAllUsers")
                .entityList(Object.class)
                .satisfies(users -> {
                    assertThat(users).isNotNull();
                    // Add more assertions as needed
                });
    }
}
