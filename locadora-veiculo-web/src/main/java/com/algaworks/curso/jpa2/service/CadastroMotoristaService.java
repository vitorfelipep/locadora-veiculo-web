package com.algaworks.curso.jpa2.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.algaworks.curso.jpa2.dao.MotoristaDao;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.curso.jpa2.util.model.Motorista;

public class CadastroMotoristaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject 
	private MotoristaDao motoristaDAO;
	
	@Transactional
	public void salvar(Motorista motorista) throws NegocioException {
		this.motoristaDAO.salvar(motorista);
	}

}
