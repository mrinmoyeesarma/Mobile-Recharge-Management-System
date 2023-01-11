package com.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ApiGatewayApplication {

private static Logger logger= LoggerFactory.getLogger(ApiGatewayApplication.class) ;
	
	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
		///System.out.println("Api Gateway is Running....");
		logger.info("Api Gateway is Running....");
	}

}
