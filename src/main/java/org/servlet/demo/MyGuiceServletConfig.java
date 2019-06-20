package org.servlet.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.annotation.WebListener;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.persist.PersistFilter;
import com.google.inject.persist.jpa.JpaPersistModule;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

@WebListener
public class MyGuiceServletConfig extends GuiceServletContextListener {

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new JpaPersistModule("axelor"), new NonServletModule(), new ServletModule() {
			@Override
			protected void configureServlets() {
				serve("/*").with(MyServlet.class);
				
//				install(new JpaPersistModule("axelor"));  // like we saw earlier.

//			    filter("/*").through(PersistFilter.class);
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