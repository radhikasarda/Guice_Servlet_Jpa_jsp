package org.servlet.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String emp_name;
	
	
	Employee(){}

	public Employee( String emp_name) {
		
		this.emp_name = emp_name;
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return emp_name;
	}

	public void setName(String name) {
		this.emp_name = emp_name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + emp_name+" ]";
	}
	
	
	
}
