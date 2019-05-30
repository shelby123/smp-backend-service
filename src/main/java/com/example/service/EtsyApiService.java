package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.EtsyPost;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

@Service
public class EtsyApiService {

	@Value("${etsy.api.key:#{null}}")
	private String apiKey;

	@Value("${etsy.url.get_listings}")
	private String etsyUrl;

	public List<EtsyPost> getPosts() {


		RestTemplate restTemplate = new RestTemplate();
		String url = String.format(etsyUrl, apiKey);

		String result = restTemplate.getForObject(url, String.class);

		String numResultsPath = "$.count";
		String listingIdPath = "$.results[*].listing_id";
		
		DocumentContext jsonContext = JsonPath.parse(result);
		
		List<EtsyPost> results = new ArrayList();
		
		List<Integer> listingIds = jsonContext.read(listingIdPath);
		
		int count = jsonContext.read(numResultsPath);
		for(Integer id : listingIds) {
//			int id = jsonContext.read(String.format(listingIdPath, i));
			EtsyPost toAdd = new EtsyPost();
			toAdd.setListingId(id);
			results.add(toAdd);
		}
		
		//      String path = "$[*].name";
		//      
		//      return jsonContext.read(path).toString();

		return results;
	}

}
