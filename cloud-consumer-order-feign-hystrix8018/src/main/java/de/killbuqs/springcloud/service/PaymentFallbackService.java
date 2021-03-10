package de.killbuqs.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService {

	@Override
	public String payOK(Integer id) {
		return "payOK fallback";
	}

	@Override
	public String payTimeout(Integer id) {
		return "payTimeout fallback";
	}

}
