package org.servlet.demo;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.persist.jpa.JpaPersistModule;

public class NonServletModule extends AbstractModule {

	@Override
	protected void configure() {
		
		
		bind(MyService.class).to(MyServiceImpl.class);

	}
}
