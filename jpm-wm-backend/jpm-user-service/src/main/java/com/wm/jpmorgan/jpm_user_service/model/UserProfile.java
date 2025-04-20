package com.wm.jpmorgan.jpm_user_service.model;

import com.wm.jpmorgan.jpm_user_service.constant.UserServiceConstants;
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
    @NotBlank(message = UserServiceConstants.ID_BLANK_ERROR)
    @Pattern(regexp = "^[a-fA-F0-9]{24}$", message = UserServiceConstants.INVALID_ID_FORMAT)
    private String id;

    @NotBlank(message = UserServiceConstants.NAME_CANNOT_BLANK)
    @Size(min = 2, max = 50, message = UserServiceConstants.NAME_LIMIT_ERROR)
    private String name;

    @Email(message = UserServiceConstants.VALID_EMAIL_ERROR)
    @NotBlank(message = UserServiceConstants.BLANK_EMAIL_ERROR)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = UserServiceConstants.INVALID_ID_FORMAT)
    private String email;

    @Min(value = 18, message = UserServiceConstants.AGE_MIN_LIMIT_ERROR)
    @Max(value = 120, message = UserServiceConstants.AGE_MAX_LIMIT_ERROR)
    private int age;

    @Size(max = 200, message = UserServiceConstants.ADDRESS_LIMIT_ERROR)
    private String address;
}
