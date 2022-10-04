package com.cof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cof.repository")
@EnableEurekaClient
public class FundraisingServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(FundraisingServiceApplication.class, args);
	}

}
