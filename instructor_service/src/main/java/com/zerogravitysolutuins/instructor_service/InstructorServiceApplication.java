package com.zerogravitysolutuins.instructor_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class InstructorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstructorServiceApplication.class, args);
	}

}
