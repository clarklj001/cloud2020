package de.killbuqs.springcloud.service;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class PaymentService {

	public String paymentOK(Integer id) {
		return "Threadpool: " + Thread.currentThread().getName() + "   paymentOK: " + id;
	}

	// Fallback
	@HystrixCommand(fallbackMethod = "paymentTimeoutHandler", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000") })
	public String paymentTimeout(Integer id) {

//		int age = 10/0;
		int timeout = 5;
		try {
			TimeUnit.SECONDS.sleep(timeout);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "Threadpool: " + Thread.currentThread().getName() + "   paymentTimeout " + timeout + "s: " + id;
	}

	public String paymentTimeoutHandler(Integer id) {
		return "Threadpool: " + Thread.currentThread().getName() + " System busy, call later.   paymentTimeoutHandler: "
				+ id;
	}

	// circuitBreaker
	@HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback", commandProperties = {
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
			})
	public String paymentCircuitBreaker(Integer id) {

		if (id < 0) {
			throw new RuntimeException("ID should be greater than 0");
		}

		String serialNumber = UUID.randomUUID().toString();

		return "Threadpool: " + Thread.currentThread().getName() + " serial number : " + serialNumber;
	}

	public String paymentCircuitBreakerFallback(Integer id) {
		return "ID should be greater than 0. Id: " + id;
	}

}
