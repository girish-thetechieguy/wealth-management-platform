package com.jpmorgan.wm.jpm_client_service.mapper;

import com.jpmorgan.wm.jpm_client_service.dto.ClientDto;
import com.jpmorgan.wm.jpm_client_service.entity.ClientRecord;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientRecordMapper {

    ClientRecord toClientRecord(ClientDto clientDto);

    ClientDto toClientDto(ClientRecord clientRecord);

}
