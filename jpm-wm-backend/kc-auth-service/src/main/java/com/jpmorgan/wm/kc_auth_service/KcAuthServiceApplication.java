package com.jpmorgan.wm.kc_auth_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class KcAuthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KcAuthServiceApplication.class, args);
	}

}
