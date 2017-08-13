package com.james.spring.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.james.spring.entity.Greeting;
import com.james.spring.entity.HypermediaGreeting;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private static final String TEMPLATE = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@RequestMapping("/greetingList")
	public List<Greeting> greetingList(@RequestParam(value = "name", defaultValue = "World") String name) {
		List<Greeting> greetingList = new ArrayList<Greeting>();
		greetingList.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));

		return greetingList;
	}

	@RequestMapping("/greetingPage")
	public String greetingPage(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		return "greeting_page";
	}

	@RequestMapping("/hypermediaGreeting")
	public HttpEntity<HypermediaGreeting> hypermediaGreeting(
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {

		HypermediaGreeting greeting = new HypermediaGreeting(String.format(TEMPLATE, name));
		greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());

		return new ResponseEntity<HypermediaGreeting>(greeting, HttpStatus.OK);
	}
}