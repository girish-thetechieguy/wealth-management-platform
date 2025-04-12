package com.wm.jpmorgan.jpm_user_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class JpmUserServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(JpmUserServiceApplication.class, args);
	}
}
