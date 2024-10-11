package utils;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryUtil {
	private EntityManagerFactory entityManageFactory;
	private EntityManager entityManager;

	public EntityManagerFactoryUtil() {
		entityManageFactory = Persistence.createEntityManagerFactory("tuan05");
		entityManager = entityManageFactory.createEntityManager();
	}
	
	public EntityManager getEnManager() {
		return entityManager;
	}

	public void close() {
		entityManager.close();
		entityManageFactory.close();
	}

}