package de.killbuqs.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderController {
	
	public static final String PAYMENT_URL = "http://cloud-payment-service";
	
	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/order")
	public String getOrder() {
		String payment = restTemplate.getForObject(PAYMENT_URL+"/payment", String.class);
		return "order:  " + payment;
	}
}
