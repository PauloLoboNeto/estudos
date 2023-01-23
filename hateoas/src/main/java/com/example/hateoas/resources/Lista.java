package com.example.hateoas.resources;

import java.util.ArrayList;

import org.springframework.hateoas.RepresentationModel;

public class Lista extends RepresentationModel<Lista> {
	private final ArrayList<Portabilidade> portabilidades;

	public Lista(ArrayList<Portabilidade> itens) {
		this.portabilidades = new ArrayList<Portabilidade>();
		itens.forEach(item -> this.portabilidades.add(new Portabilidade(item.getId(), item.getBanco())));
	}

	public ArrayList<Portabilidade> getPortabilidades() {
		return portabilidades;
	}
}
