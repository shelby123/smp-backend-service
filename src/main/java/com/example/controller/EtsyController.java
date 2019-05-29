package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/etsy")
public class EtsyController {

	@GetMapping("/test")
	public String test() {
		return "Hello, world!";
	}
	
	
}
