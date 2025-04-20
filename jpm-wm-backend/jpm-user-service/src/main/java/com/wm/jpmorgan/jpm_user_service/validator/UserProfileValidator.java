package com.wm.jpmorgan.jpm_user_service.validator;

import com.wm.jpmorgan.jpm_user_service.exception.BadRequestException;
import com.wm.jpmorgan.jpm_user_service.exception.FailedPreconditionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.apache.commons.lang3.StringUtils;

@Component
@RequiredArgsConstructor
public class UserProfileValidator {
    public void validateCreate(String name, String email, int age, String address) {
        if (StringUtils.isBlank(name)) {
            throw new BadRequestException("Name cannot be empty");
        }
        if (StringUtils.isBlank(email) || !email.contains("@")) {
            throw new BadRequestException("Invalid email format");
        }
        if (age < 18) {
            throw new FailedPreconditionException("Age must be at least 18");
        }
    }

    public void validateUpdate(String id, String name, String email, Integer age, String address) {
        if (StringUtils.isBlank(id)) {
            throw new BadRequestException("ID cannot be empty");
        }
        if (name != null && name.length() > 100) {
            throw new BadRequestException("Name exceeds 100 characters");
        }
        if (email != null && !email.contains("@")) {
            throw new BadRequestException("Invalid email format");
        }
        if (age != null && age < 0) {
            throw new FailedPreconditionException("Age cannot be negative");
        }
    }

    public void validateId(String id) {
    }
}
