package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.EtsyImage;
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
	
	@GetMapping(value="/pathParam/{value}")
	public String pathParameter(@PathVariable("value") int val) {
		return "Path parameter value : " + val;
	}
	
	
	@CrossOrigin
	@GetMapping("/listings")
	public List<EtsyPost> getListings() {
        return etsyService.getPosts(); 
	}
	
	@CrossOrigin
	@GetMapping(value="/listings/{id}/images")
	public List<EtsyImage> getListingImages(@PathVariable("id") int id) {
		return etsyService.getPostImages(id);
	}
	
	
}







