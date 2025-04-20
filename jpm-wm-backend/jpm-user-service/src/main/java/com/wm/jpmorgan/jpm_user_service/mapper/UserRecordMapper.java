package com.wm.jpmorgan.jpm_user_service.mapper;

import com.wm.jpmorgan.jpm_user_service.dto.UserDTO;
import org.mapstruct.Mapper;
import  com.wm.jpmorgan.jpm_user_service.model.UserProfile;

@Mapper(componentModel = "spring")
public interface UserRecordMapper {
    UserProfile toClientRecord(UserDTO userDTO);

    UserDTO toClientDto(UserProfile userProfile);
}
