package com.demo.security.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {
	
	@GetMapping("/welcome")
	public String getWelcome() {
		return "Welcome to my Website";
	}
	

}
