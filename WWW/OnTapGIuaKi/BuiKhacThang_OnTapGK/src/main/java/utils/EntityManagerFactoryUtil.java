package utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory emf;
	private EntityManager em;
	
	
	public EntityManagerFactoryUtil() {
			emf = Persistence.createEntityManagerFactory("ontap");
			em = emf.createEntityManager();
	}


	public EntityManager getEm() {
		return em;
	}

	public void close() {
		emf.close();
		em.close();
	}
}
