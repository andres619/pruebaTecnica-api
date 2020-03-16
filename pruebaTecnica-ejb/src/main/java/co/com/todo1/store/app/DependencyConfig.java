package co.com.todo1.store.app;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DependencyConfig {

	@PersistenceContext(name = "PruebaTecnicaPU")
	private EntityManager entityManager;

	@Produces
	@Dependent
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
