package com.example.hateoas.resources;

public class Portabilidade {
	private final String id;
	private final String banco;

	public Portabilidade(String id, String banco) {
		this.id = id;
		this.banco = banco;
	}

	public String getId() {
		return id;
	}

	public String getBanco() {
		return banco;
	}
}
