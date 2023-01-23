package com.example.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.resources.RootEntryPointModel;

@RestController
public class EntryPointController {
	
	@GetMapping(produces = { "application/hal+json" })
	public HttpEntity<RootEntryPointModel> entryPoint() {
		RootEntryPointModel model = new RootEntryPointModel();
		
		model.add(
				linkTo(
					methodOn(PortabilidadeAtaqueController.class)
						.getLista())
						.withRel(IanaLinkRelations.NEXT)
						.withName("lista"));
		
		
		return new ResponseEntity<RootEntryPointModel>(model, HttpStatus.ACCEPTED);
	}
 
}
