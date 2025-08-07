package com.example.circuitbreaker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.circuitbreaker.service.ExternalService;

@RestController
public class DemoController {
	
	@Autowired
	private ExternalService externalService;
	
	@GetMapping("/call")
	public String makeCall() {
		return externalService.callExternalApi();
	}

}
