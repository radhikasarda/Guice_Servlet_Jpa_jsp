package org.servlet.demo;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;


public class MyGuiceServletConfig extends GuiceServletContextListener {
	
	
	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new NonServletModule(), new ServletModule() {
			@Override
			protected void configureServlets() {
			
				serve("/MyServlet").with(MyServlet.class);
				install(new JpaPersistModule("axelor")); 
				filter("/*").through(PersistFilter.class);
			
				
			}

		});
		
	}
	
	

}

/*
 * @WebListener public class MyGuiceServletConfig extends AbstractModule {
 * 
 * //Injector injector = Guice.createInjector(new ServletModule());
 * 
 * @Override protected void configure() {
 * 
 * bind(MyService.class).to(MyServiceImpl.class);
 * 
 * 
 * }
 * 
 * 
 * protected Injector getInjector() { return Guice.createInjector( new
 * ServletModule() {
 * 
 * @Override protected void configureServlets() {
 * 
 * //bind(MyService.class).to(MyServiceImpl.class);
 * serve("/*").with(MyServlet.class);
 * 
 * } },new MyGuiceServletConfig());
 * 
 * 
 * 
 * } }
 */