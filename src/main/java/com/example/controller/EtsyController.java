package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EtsyPost;
import com.example.service.EtsyApiService;


@RestController
@RequestMapping("/etsy")
public class EtsyController {
	
	@Autowired
	private EtsyApiService etsyService;
	
	@GetMapping("/test")
	public String test() {
		return "Hello, world!";
	}
	
	
	@GetMapping("/listings")
	public List<EtsyPost> getListings() {
        return etsyService.getPosts();
	}
	
}
