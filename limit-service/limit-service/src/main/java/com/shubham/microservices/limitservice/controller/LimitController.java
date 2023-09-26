package com.shubham.microservices.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shubham.microservices.limitservice.dto.ConfigurationDTO;
import com.shubham.microservices.limitservice.dto.LimitDTO;

@RestController
public class LimitController {
	
	@Autowired
	private ConfigurationDTO configurationDTO;
	
	@GetMapping("/getLimits")
	public LimitDTO getLimit() {
		return new LimitDTO(configurationDTO.getMinimum(),configurationDTO.getMaximum());
		//return new LimitDTO(1, 1000);
	}

}
