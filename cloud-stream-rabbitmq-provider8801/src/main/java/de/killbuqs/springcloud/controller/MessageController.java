package de.killbuqs.springcloud.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.killbuqs.springcloud.service.IMessageProvider;

@RestController
public class MessageController {
	
	@Resource
	private IMessageProvider messageProvider;
	
	@GetMapping("/sendMessage")
	public String sendMessage() {
		return messageProvider.send();
	}
	
}
