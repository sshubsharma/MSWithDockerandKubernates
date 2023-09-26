package com.shubham.microservices.currencyExchangeService;

//import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CurrencyExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchangeDTO retriveExchangeValue(
			@PathVariable String from,
			@PathVariable String to) {
		
		//CurrencyExchangeDTO  currencyExchangeDTO=new CurrencyExchangeDTO(1000L,from, to, BigDecimal.valueOf(50));
		CurrencyExchangeDTO  currencyExchangeDTO=repository.findByFromAndTo(from,to);
		if(null==currencyExchangeDTO) {
			throw new RuntimeException("Unable to find the data for" + from + " " + to);
		}
		String port=environment.getProperty("local.server.port");
		currencyExchangeDTO.setEnv(port);
		return currencyExchangeDTO;
	}
	

}
