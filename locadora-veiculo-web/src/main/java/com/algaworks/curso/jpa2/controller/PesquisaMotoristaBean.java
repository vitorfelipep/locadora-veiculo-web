package com.algaworks.curso.jpa2.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.MotoristaDao;
import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import com.algaworks.curso.jpa2.util.model.Motorista;

@Named
@ViewScoped
public class PesquisaMotoristaBean {

	@Inject
	MotoristaDao motoristaDao;

	private List<Motorista> motoristas = new ArrayList<>();

	private Motorista motoristaSelecionado;
	
	public void inicializar() {
		motoristas = motoristaDao.buscarTodos();
	}
	
	public void excluir() {
		try {
			motoristaDao.excluir(motoristaSelecionado);
			this.motoristas.remove(motoristaSelecionado);
			FacesUtil.addSuccessMessage("Motorista " + motoristaSelecionado.getNome() + " excluido com sucesso!" );
		}catch (NegocioException e) {
			FacesUtil.addErrorMessage("Não foi possivel excluir motorista devido a um erro no sistema!");
		}
	} 
	
	public List<Motorista> getMotoristas() {
		return motoristas;
	}

	public void setMotoristas(List<Motorista> motoristas) {
		this.motoristas = motoristas;
	}

	public Motorista getMotoristaSelecionado() {
		return motoristaSelecionado;
	}

	public void setMotoristaSelecionado(Motorista motoristaSelecionado) {
		this.motoristaSelecionado = motoristaSelecionado;
	}

}
