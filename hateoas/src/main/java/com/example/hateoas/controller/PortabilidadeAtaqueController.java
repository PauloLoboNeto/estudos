package com.example.hateoas.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.UUID;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.controller.req.DetalheReq;
import com.example.hateoas.resources.Detalhe;
import com.example.hateoas.resources.Lista;
import com.example.hateoas.resources.Portabilidade;

@RestController
@RequestMapping("/tracking")
public class PortabilidadeAtaqueController {

	@GetMapping(value = "/lista", produces = { "application/hal+json" })
	public HttpEntity<Lista> getLista() {

		// Obtém os recursos de resposta de alguma API; --->
		ArrayList<Portabilidade> portabilidade = new ArrayList<>();
		portabilidade.add(new Portabilidade(UUID.randomUUID().toString(), "BANCO"));
		portabilidade.add(new Portabilidade(UUID.randomUUID().toString(), "BANCO"));
		portabilidade.add(new Portabilidade(UUID.randomUUID().toString(), "BANCO"));
		// ------------------------------------------------->

		Lista lista = new Lista(portabilidade);

		lista.add(linkTo(methodOn(PortabilidadeAtaqueController.class).getLista()).withSelfRel().withName("lista"));
		lista.add(linkTo(
				methodOn(PortabilidadeAtaqueController.class).getDetalhes(new DetalheReq(UUID.randomUUID().toString())))
				.withRel(IanaLinkRelations.NEXT).withName("detalhe"));

		return new ResponseEntity<Lista>(lista, HttpStatus.OK);
	}

	@PostMapping(value = "/detalhes", produces = { "application/hal+json" })
	public HttpEntity<Detalhe> getDetalhes(@RequestBody(required = true) DetalheReq detalhe) {
		System.out.println(detalhe.getId());
		// Obtém os recursos de resposta de alguma API; --->
		Detalhe resp = new Detalhe(MessageFormat.format("detalhes da resposta para o id {0}", detalhe.getId()));
		// ------------------------------------------------->

		resp.add(linkTo(
				methodOn(PortabilidadeAtaqueController.class).getDetalhes(new DetalheReq(UUID.randomUUID().toString())))
				.withSelfRel().withName("detalhe"));

		resp.add(linkTo(methodOn(PortabilidadeAtaqueController.class).getLista()).withRel(IanaLinkRelations.PREVIOUS)
				.withName("lista"));

		return new ResponseEntity<Detalhe>(resp, HttpStatus.OK);
	}
}
