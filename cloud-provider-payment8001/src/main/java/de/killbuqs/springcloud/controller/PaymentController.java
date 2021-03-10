package de.killbuqs.springcloud.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarklj001.springcloud.commons.Roles;

import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/payment")
@Log4j2
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping
	public String pay() {
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "pay as " + Roles.ROLE_ADMIN + ", portNumber: " + serverPort;
	}

	@GetMapping("/discovery")
	public Object discovery() {
		List<String> services = discoveryClient.getServices();
		for (String service : services) {
			log.info("********element: " + service);
			System.out.println("********element: " + service);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		for (ServiceInstance serviceInstance : instances) {
			log.info(serviceInstance.getServiceId() + ", " + serviceInstance.getHost() + ", "
					+ serviceInstance.getPort() + ", " + serviceInstance.getUri());
			System.out.println(serviceInstance.getServiceId() + ", " + serviceInstance.getHost() + ", "
					+ serviceInstance.getPort() + ", " + serviceInstance.getUri());
		}
		return this.discoveryClient;
	}

}
