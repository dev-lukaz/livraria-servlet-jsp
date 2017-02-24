package br.com.livraria.service;

import br.com.livraria.dao.DAOFactory;

public abstract class Service {
	
	protected ServiceFactory serviceFactory;
	protected DAOFactory daoFactory;
	
	protected Service() {
		this.serviceFactory = ServiceFactory.getInstance();
		this.daoFactory = DAOFactory.getInstance();
	}
}
