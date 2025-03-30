package com.jpmorgan.wm.jpm_client_service.service;

import com.jpmorgan.wm.jpm_client_service.dto.ClientDto;
import com.jpmorgan.wm.jpm_client_service.entity.ClientRecord;
import com.jpmorgan.wm.jpm_client_service.mapper.ClientRecordMapper;
import com.jpmorgan.wm.jpm_client_service.repository.ClientRepository;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {


    private final ClientRepository clientRepository;

    private final ClientRecordMapper clientRecordMapper;

    @Autowired
    public ClientService(ClientRepository clientRepository, ClientRecordMapper clientRecordMapper) {
        this.clientRepository = clientRepository;
        this.clientRecordMapper = clientRecordMapper;
    }


    public ClientDto createClient(ClientDto gymRecordDto) {
        gymRecordDto.setPassword(this.hashPassword(gymRecordDto.getPassword()));
        ClientRecord gymRecord = clientRecordMapper.toClientRecord(gymRecordDto);
        ClientRecord savedGymRecord = clientRepository.save(gymRecord);
        return clientRecordMapper.toClientDto(savedGymRecord);
    }

    private String hashPassword(String password){
        try {
            // Create a MessageDigest instance for SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            // Perform the hashing
            byte[] hash = digest.digest(password.getBytes());

            // Convert byte array to hexadecimal format
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            // Return the hashed password as a hexadecimal string
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error hashing password", e);
        }
    }

}
