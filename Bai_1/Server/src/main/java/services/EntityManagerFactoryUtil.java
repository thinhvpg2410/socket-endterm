package services;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;
	
	public EntityManagerFactoryUtil() {
		entityManagerFactory = Persistence.createEntityManagerFactory("de_1"); //servername
		entityManager = entityManagerFactory.createEntityManager();
	}
	public EntityManager getEntityManager() {
		return entityManager;
	}
	public void closeEntityManager() {
		entityManager.close();
	}
	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}
}
