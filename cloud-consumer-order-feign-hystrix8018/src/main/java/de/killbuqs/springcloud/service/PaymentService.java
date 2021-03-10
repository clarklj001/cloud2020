package de.killbuqs.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE-HYSTRIX", fallback = PaymentFallbackService.class)
public interface PaymentService {

	@GetMapping("/payment/hystrix/ok/{id}")
	public String payOK(@PathVariable("id") Integer id);

	@GetMapping("/payment/hystrix/timeout/{id}")
	public String payTimeout(@PathVariable("id") Integer id);
}
