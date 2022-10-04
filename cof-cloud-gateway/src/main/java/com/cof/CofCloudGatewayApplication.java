package com.cof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CofCloudGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(CofCloudGatewayApplication.class, args);
	}

}
