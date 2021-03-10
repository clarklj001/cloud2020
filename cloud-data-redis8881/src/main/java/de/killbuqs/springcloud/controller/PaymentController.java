package de.killbuqs.springcloud.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
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

}
