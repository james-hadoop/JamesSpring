package com.james.spring.entity;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class HypermediaGreeting extends ResourceSupport {

	private final String content;

	@JsonCreator
	public HypermediaGreeting(@JsonProperty("content") String content) {
		this.content = content;
	}

	public String getContent() {
		return content;
	}
}