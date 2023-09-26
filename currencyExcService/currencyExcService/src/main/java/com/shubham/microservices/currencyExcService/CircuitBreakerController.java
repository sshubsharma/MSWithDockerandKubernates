package com.shubham.microservices.currencyExcService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;

@RestController
public class CircuitBreakerController {
	private Logger logger=LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sampleApi")
	//by default it will retry 3 times
	//@Retry(name="sample-Api",fallbackMethod="hardcodedResponse")
	//@CircuitBreaker(name="default",fallbackMethod="hardcodedResponse")
	//@RateLimiter(name="default")
	//10s--> 1000 calls to the sample api
	@Bulkhead(name="sample-api")
	// how many concurrent calls you want
	public String sampleApi() {
		logger.info("sample api request received");
		/*
		 * ResponseEntity<String> response=new
		 * RestTemplate().getForEntity("localhost:8080/sample-api",String.class);
		 */
		return "sample api call";
	}
	
	public String hardcodedResponse(Exception ex) {
		return "this is fallback method Response";
	}
	
}
