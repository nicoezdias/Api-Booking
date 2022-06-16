package com.PI.apiBooking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "my.property")
@SpringBootApplication
public class ProjectApplication {
	private static Integer cafe;
	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
		System.out.println(cafe);
	}

}
