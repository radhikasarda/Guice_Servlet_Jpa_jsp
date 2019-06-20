package org.servlet.demo;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;

@Singleton
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Inject
    private MyService myService;


    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.getWriter().write(myService.hello("Radhika"));
    	Employee emp = new Employee();
    	myService.saveEmployee(emp);
    	
    	    
    }
}