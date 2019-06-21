package org.servlet.demo;

import com.google.inject.ImplementedBy;

@ImplementedBy(MyServiceImpl.class)
public interface MyService {
		String hello(String name);
		void saveEmployee(Employee employee);

	
}