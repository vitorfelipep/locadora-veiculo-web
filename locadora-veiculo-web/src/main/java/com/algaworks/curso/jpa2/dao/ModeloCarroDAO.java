package com.algaworks.curso.jpa2.dao;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import com.algaworks.curso.jpa2.service.NegocioException;
import com.algaworks.curso.jpa2.util.jpa.Transactional;
import com.algaworks.curso.jpa2.util.model.ModeloCarro;

public class ModeloCarroDAO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public ModeloCarro buscarPeloCodigo(Long codigo) {
		return manager.find(ModeloCarro.class, codigo);
	}
	
	public void salvar(ModeloCarro modeloCarro) {
		manager.merge(modeloCarro);
	}
	
	@SuppressWarnings("unchecked")
	public List<ModeloCarro> buscarTodos() {
		return manager.createQuery("from ModeloCarro").getResultList();
	}
	
	@Transactional
	public void excluir(ModeloCarro modeloCarro) throws NegocioException{
		try{
			modeloCarro = manager.find(ModeloCarro.class, modeloCarro.getCodigo());
			manager.remove(modeloCarro);
			manager.flush();
		}catch (PersistenceException e) {
			e.printStackTrace();
		}
	}
}
