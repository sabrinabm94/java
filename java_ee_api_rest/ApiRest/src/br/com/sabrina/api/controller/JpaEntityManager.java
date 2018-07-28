package br.com.sabrina.api.controller;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaEntityManager {
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("provider");
	private EntityManager entityManager = factory.createEntityManager();
	
	public EntityManager getEntityManager() {
		return entityManager;
	}
}