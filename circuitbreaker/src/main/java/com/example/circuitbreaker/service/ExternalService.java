package com.example.circuitbreaker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ExternalService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@CircuitBreaker(name = "externalService", fallbackMethod="fallbackMethod")
	public String callExternalApi() {
		String response = restTemplate.getForObject("http://localhost:9090/some-api",String.class);
				return "Success:"+ response;
	}
	
	public String fallbackMethod(Throwable t) {
		return "FallBack: Service is currently unavilable."+t.getMessage();
	}

}
