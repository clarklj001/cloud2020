package de.killbuqs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {
	
	@GetMapping("/payment")
	 String pay();
}
