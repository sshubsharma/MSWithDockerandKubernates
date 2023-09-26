package com.shubham.microservices.apigateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class APIGateWayConfiguration {
	
	@Bean
	public  RouteLocator gateWayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				/*
				 * .route(p -> p .path("/get") .filters(f -> f .addRequestHeader("MyHeader",
				 * "MyURI") .addRequestParameter("Param", "MyValue"))
				 * .uri("http://httpbin.org:80")) .route(p -> p.path("/exchange-service/**")
				 * .uri("lb://exchange-service")) .route(p -> p.path("/exchange-service/**")
				 * .uri("lb://exchange-service"))
				 * 
				 * .route(p -> p.path("/currency-conversion-new/**") .filters(f ->
				 * f.rewritePath( "/currency-conversion-new/(?<segment>.*)",
				 * "/currency-conversion-feign/${segment}")) .uri("lb://currency-conversion"))
				 */
				.build();
		
	}

}
