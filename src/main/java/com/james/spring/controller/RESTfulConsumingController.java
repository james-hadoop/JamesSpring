package com.james.spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.james.spring.entity.Quote;

@RestController
public class RESTfulConsumingController {
	@RequestMapping("/restfulConsuming")
	public String restfulConsuming() {
		RestTemplate restTemplate = new RestTemplate();
		Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		return quote.toString();
	}
}
