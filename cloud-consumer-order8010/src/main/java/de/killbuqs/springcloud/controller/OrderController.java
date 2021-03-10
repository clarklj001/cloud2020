package de.killbuqs.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import de.killbuqs.springcloud.service.PaymentService;

@RestController
public class OrderController {
	
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
	
	@Resource
	private RestTemplate restTemplate;
	
	@Resource
	private PaymentService paymentService;

	@GetMapping("/order")
	public String getOrder() {
		String payment = restTemplate.getForObject(PAYMENT_URL+"/payment", String.class);
		return "order:  " + payment;
	}
	
	@GetMapping("/feignOrder")
	public String getFeignOrder() {
		String payment = paymentService.pay();
		return "order:  " + payment;
	}
}
