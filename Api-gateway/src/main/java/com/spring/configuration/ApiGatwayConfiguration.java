package com.spring.configuration;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatwayConfiguration {
	@Bean
	public RouteLocator gatewayRouter (RouteLocatorBuilder builder) {
		return builder.routes().                
                route(p->p.path("/api/posts/**").uri("lb://AdminService"))            
                .route(p->p.path("/api/customer/**").uri("lb://CustomerService"))
                .route(p->p.path("/api/user/**").uri("lb://LoginService"))
                .build();
	}

}
