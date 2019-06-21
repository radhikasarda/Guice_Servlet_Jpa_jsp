package org.servlet.demo;

import javax.inject.Singleton;
import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

@Singleton
public class MyServiceImpl implements MyService {

	@Inject
	Provider<EntityManager> entityManagerProvider;

	EntityManager entityManager;

	public String hello(String name) {
		return "Hello, " + name;
	}

	@Transactional
	public void saveEmployee(Employee employee) {

		entityManager = entityManagerProvider.get();

		employee.setName("Radhika");

		entityManager.persist(employee);

	}

}