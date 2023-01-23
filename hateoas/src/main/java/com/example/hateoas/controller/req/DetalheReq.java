package com.example.hateoas.controller.req;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DetalheReq {

	private final String id;
	
	@JsonCreator
	public DetalheReq(@JsonProperty("id") String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}	
}
