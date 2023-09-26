package com.shubham.microservices.currencyConversionService;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Configuration(proxyBeanMethods = false)
class RestTemplateConfiguration {
    
    @Bean
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	@Autowired
	private RestTemplate template;
	
	
	
	// this call by using rest template
	/*
	 * @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	 * public CurrencyConversion calculateCurrencyConversion(@PathVariable String
	 * from,
	 * 
	 * @PathVariable String to,
	 * 
	 * @PathVariable BigDecimal quantity) {
	 * 
	 * Map<String,String> uriVariables=new HashMap<>();
	 * uriVariables.put("from",from); uriVariables.put("to",to);
	 * 
	 * ResponseEntity<CurrencyConversion> response=new RestTemplate().getForEntity(
	 * "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
	 * CurrencyConversion.class,uriVariables); CurrencyConversion
	 * currencyConversion=response.getBody(); return new
	 * CurrencyConversion(currencyConversion.getId(),from,to,quantity,
	 * currencyConversion.getConversionMultiple(),quantity.multiply(
	 * currencyConversion.getConversionMultiple()),
	 * currencyConversion.getEnvironment()); }
	 */
	
	
	//this call by using Feign client
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity) {
		
		Map<String,String> uriVariables=new HashMap<>();
		uriVariables.put("from",from);
		uriVariables.put("to",to);
		
		CurrencyConversion currencyConversion=proxy.retriveExchangeValue(from,to);
		//CurrencyConversion currencyConversion=response.getBody();
		return new CurrencyConversion(currencyConversion.getId(),from,to,quantity,
				currencyConversion.getConversionMultiple(),quantity.multiply(currencyConversion.getConversionMultiple()),
				currencyConversion.getEnvironment());
	}

}
