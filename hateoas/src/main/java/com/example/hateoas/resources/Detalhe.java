package com.example.hateoas.resources;

import org.springframework.hateoas.RepresentationModel;

public class Detalhe extends RepresentationModel<Detalhe>{

	private final String detalhe;
	
	public Detalhe(String detalhe) {
		this.detalhe = detalhe;
	}

	public String getDetalhe() {
		return detalhe;
	}
	
}
