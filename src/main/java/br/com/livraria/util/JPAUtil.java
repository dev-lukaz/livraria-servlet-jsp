package br.com.livraria.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	public static final String PERSISTENCE_UNIT_NAME = "livraria";
	private static PersistenceProperties properties;
	private static EntityManagerFactory factory;
	private EntityManager manager;
	
	private static JPAUtil instance;

	private JPAUtil() {
		properties = new PersistenceProperties();
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME, properties.get());
	}
	
	public static JPAUtil getInstance() {
		if (instance == null) {
			instance = new JPAUtil();
		}
		return instance;
	}
	
	public EntityManager createEntityManager() {
		this.manager = factory.createEntityManager();
		return this.manager;
	}

	public EntityManager getEntityManager() {
		return this.manager;
	}
}
