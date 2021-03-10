package de.killbuqs.springcloud;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/guonei")
//						.filters(f -> f.rewritePath("/rest/", "/"))
						.uri("http://news.baidu.com"))
				
				.route(p -> p.path("/guoji")
//						.filters(f -> f.rewritePath("/rest/", "/"))
						.uri("http://news.baidu.com/guoji"))

				.route(p -> p.path("/payment/hystrix/timeout/**")
//						.filters(f -> f.rewritePath("/rest/", "/"))
						.uri("lb://cloud-payment-service-hystrix"))
				
				.build();
	}

}
