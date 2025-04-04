package com.jpmorgan.wm.jpm_client_service.controller;

import com.jpmorgan.wm.jpm_client_service.dto.ClientDto;
import com.jpmorgan.wm.jpm_client_service.service.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/client/app/v1")
@RequiredArgsConstructor
public class ClientController {

    Logger logger = Logger.getLogger(ClientController.class.getName());

    @Autowired
    private ClientService clientService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientDto> registerClient(@RequestBody ClientDto recordDto) {
        long startTime = System.currentTimeMillis();
        ClientDto createdRecord = clientService.createClient(recordDto);
        ResponseEntity<ClientDto> result = ResponseEntity.created(URI.create("/client/register/" + recordDto.getId())).body(createdRecord);
        long endTime = System.currentTimeMillis();
        logger.info("ClientController.RegisterClient() API call execution time: " + (endTime - startTime) + " ms");
        return result;
    }


}
