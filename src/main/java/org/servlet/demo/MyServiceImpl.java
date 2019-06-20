package org.servlet.demo;

import javax.persistence.EntityManager;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.persist.Transactional;

public class MyServiceImpl implements MyService {

	@Inject 
	Provider<EntityManager> entityManagerProvider ;
	
	@Inject
	EntityManager entityManager;

	public String hello(String name) {
		return "Hello, " + name;
	}

	@Transactional
	public void saveEmployee(Employee emp) {
 
		entityManager = entityManagerProvider.get();
		
		try {
		entityManager.getTransaction().begin();
		emp.setName("Radhika");

		entityManager.persist(emp);
		entityManager.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Hey there!!");
		}
	}

}