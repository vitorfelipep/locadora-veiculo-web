package com.algaworks.curso.jpa2.util.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "motorista")
@DiscriminatorValue("MOTORISTA")
public class Motorista extends Pessoa{

	private static final long serialVersionUID = 1L;
	
	private String numeroCNH;
	
	@Column(name = "numero_cnh")
	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}
}
