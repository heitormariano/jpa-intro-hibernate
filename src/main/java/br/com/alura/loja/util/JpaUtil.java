package br.com.alura.loja.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("loja");
	protected static EntityManager entityManager;

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			entityManager = FACTORY.createEntityManager();
		}
		return entityManager;
	}
}
