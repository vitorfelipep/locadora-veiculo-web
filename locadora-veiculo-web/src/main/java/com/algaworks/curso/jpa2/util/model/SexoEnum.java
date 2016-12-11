package com.algaworks.curso.jpa2.util.model;

public enum SexoEnum {
	MASCULINO("Masculino"), FEMININO("Feminino");

	private String descricao;

	private SexoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
