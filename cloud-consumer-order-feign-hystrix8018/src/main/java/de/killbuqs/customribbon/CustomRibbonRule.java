package de.killbuqs.customribbon;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

@Configuration
public class CustomRibbonRule {

	@Bean
	public IRule customRule() {
		return new RandomRule();
	}
}
