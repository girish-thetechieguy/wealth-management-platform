package com.wm.jpmorgan.jpm_user_service.mapper;

import com.wm.jpmorgan.jpm_user_service.dto.UserDTO;
import com.wm.jpmorgan.jpm_user_service.model.UserProfile;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserRecordMapper {
    UserProfile toClientRecord(UserDTO userDTO);

    UserDTO toClientDto(UserProfile userProfile);
}
