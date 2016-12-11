package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.service.CadastroMotoristaService;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import com.algaworks.curso.jpa2.util.model.Motorista;
import com.algaworks.curso.jpa2.util.model.SexoEnum;

@Named
@ViewScoped
public class CadastroMotoristaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Motorista motorista;
	

	private List<SexoEnum> sexos;
	
	@Inject
	private CadastroMotoristaService cadastroMotoristaService;
	
	public CadastroMotoristaBean() {
	
	}
	
	@PostConstruct
	public void inicializar() {
		this.limpar();
		this.setSexos(Arrays.asList(SexoEnum.values()));
	}
	 
	public void salvar() {
		try { 
			this.cadastroMotoristaService.salvar(motorista);
			FacesUtil.addSuccessMessage("Motorista salvo com sucesso!");
		} catch (NegocioException e) {
			FacesUtil.addErrorMessage(e.getMessage());
		}
		
		this.limpar();
	}

	private void limpar() {
		motorista = new Motorista();
	}

	public List<SexoEnum> getSexos() {
		return sexos;
	}

	public void setSexos(List<SexoEnum> sexos) {
		this.sexos = sexos;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}
