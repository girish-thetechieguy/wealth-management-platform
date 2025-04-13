package com.wm.jpmorgan.jpm_user_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

@Document(collection = "user_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserProfile {
    @Id
    @NotBlank(message = "ID cannot be blank")
    @Pattern(regexp = "^[a-fA-F0-9]{24}$", message = "Invalid ID format")
    private String id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 2, max = 50, message = "Name must be between 2-50 characters")
    private String name;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 120, message = "Age must be less than 120")
    private int age;

    @Size(max = 200, message = "Address cannot exceed 200 characters")
    private String address;
}
