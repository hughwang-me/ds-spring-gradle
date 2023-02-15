package ds.spring.gradle.service.impl;

import lombok.Getter;
import org.mx.dal.service.EntityManagerService;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SuppressWarnings("javadoc")
public class EntityManagerServiceImpl implements EntityManagerService {
	@PersistenceContext(name = "entityManager")
	@Qualifier("entityManager")
	@Getter
	private EntityManager entityManager;
}
