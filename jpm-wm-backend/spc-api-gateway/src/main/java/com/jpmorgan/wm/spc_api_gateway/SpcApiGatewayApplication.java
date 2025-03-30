package com.jpmorgan.wm.spc_api_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpcApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpcApiGatewayApplication.class, args);
	}

}
