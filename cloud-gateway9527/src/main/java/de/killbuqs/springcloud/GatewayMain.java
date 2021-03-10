package de.killbuqs.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GatewayMain {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(GatewayMain.class, args);
	}

}
