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

		String listingIdPath = "$.results[*].listing_id";
		String titlePath = "$.results[*].title";
		String imageUrlPath = "$.results[*].MainImage.url_75x75";
		
		DocumentContext jsonContext = JsonPath.parse(result);
		
		List<EtsyPost> results = new ArrayList();
		
		List<Integer> listingIds = jsonContext.read(listingIdPath);
		List<String> titles = jsonContext.read(titlePath);
		List<String> imageUrls = jsonContext.read(imageUrlPath);
		
		for(int i = 0; i < listingIds.size(); i++) {
			EtsyPost toAdd = new EtsyPost();
			toAdd.setListingId(listingIds.get(i));
			toAdd.setTitle(titles.get(i));
			toAdd.setImageUrl(imageUrls.get(i));
			results.add(toAdd);
		}
		return results;
	}

}
