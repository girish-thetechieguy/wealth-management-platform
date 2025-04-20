package com.wm.jpmorgan.jpm_user_service.dto;

import com.wm.jpmorgan.jpm_user_service.constant.UserServiceConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;


@Data
public class UserDTO {
    private String id;

    private String name;

    private String email;

    private int age;

    private String address;
}
