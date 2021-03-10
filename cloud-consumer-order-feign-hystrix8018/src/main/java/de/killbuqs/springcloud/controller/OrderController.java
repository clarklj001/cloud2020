package de.killbuqs.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import de.killbuqs.springcloud.service.PaymentService;

@RestController
//@DefaultProperties(defaultFallback = "globalFallback")
public class OrderController {

	@Resource
	private PaymentService paymentService;

	@GetMapping("/order/ok/{id}")
//	@HystrixCommand
	public String getOrdeOKr(@PathVariable Integer id) {
		return paymentService.payOK(id);
	}

	@GetMapping("/order/timeout/{id}")
//	@HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
//			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500") })
	public String getOrderTimeout(@PathVariable Integer id) {
//		int age = 10/0;
		return paymentService.payTimeout(id);
	}

	public String paymentTimeoutHandler(Integer id) {
		return "Threadpool: " + Thread.currentThread().getName() + " OrderController busy, call later.   paymentTimeoutHandler: "
				+ id;
	}
	
	public String globalFallback() {
		return "globalFallback";
	}
}
