package de.killbuqs.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarklj001.springcloud.commons.Roles;

import de.killbuqs.springcloud.service.PaymentService;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private PaymentService paymentService;

	@GetMapping("/hystrix/ok/{id}")
	public String payOK(@PathVariable Integer id) {

		String result = paymentService.paymentOK(id);

		log.info("******result: " + result);

		return result;
	}

	@GetMapping("/hystrix/timeout/{id}")
	public String payTimeout(@PathVariable Integer id) {

		String result = paymentService.paymentTimeout(id);

		log.info("******result: " + result);

		return result;
	}

	@GetMapping("/hystrix/circuit/{id}")
	public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
		
		String result = paymentService.paymentCircuitBreaker(id);
		
		log.info("******result: " + result);
		
		
		return result;

	}

}
