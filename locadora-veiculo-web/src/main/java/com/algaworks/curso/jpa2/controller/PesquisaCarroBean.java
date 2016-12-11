package com.algaworks.curso.jpa2.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.algaworks.curso.jpa2.dao.CarroDAO;
import com.algaworks.curso.jpa2.util.jsf.FacesUtil;
import com.algaworks.curso.jpa2.util.model.Carro;

@Named
@ViewScoped
public class PesquisaCarroBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private CarroDAO carroDAO;
	
	private List<Carro> carros = new ArrayList<>();
	
	private Carro carroSelecionado;
	
	public PesquisaCarroBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void excluir() {
		try{
			carroDAO.excluir(carroSelecionado);
			this.carros.remove(carroSelecionado);
			FacesUtil.addSuccessMessage("Carro de placa: " + carroSelecionado.getPlaca() + " excluido com sucesso!");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarCarroComAcessorios() {
		carroSelecionado = carroDAO.buscarCarroComAcessorios(carroSelecionado.getCodigo());
	}
	
	@PostConstruct
	public void initializer() {
		carros = carroDAO.buscarTodos();
	}
	
	//############################################################################################//
	
	public CarroDAO getCarroDAO() {
		return carroDAO;
	}

	public void setCarroDAO(CarroDAO carroDAO) {
		this.carroDAO = carroDAO;
	}

	public List<Carro> getCarros() {
		return carros;
	}

	public void setCarros(List<Carro> carros) {
		this.carros = carros;
	}

	public Carro getCarroSelecionado() {
		return carroSelecionado;
	}

	public void setCarroSelecionado(Carro carroSelecionado) {
		this.carroSelecionado = carroSelecionado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
