package com.wm.jpmorgan.jpm_user_service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${db-name}")
    private String dbname;

    @GetMapping("/test")
    public String test() {
        return "dbname: " + dbname;
    }
}
