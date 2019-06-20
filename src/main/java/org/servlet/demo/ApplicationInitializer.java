package org.servlet.demo;

import com.google.inject.Inject;
import com.google.inject.persist.PersistService;

public class ApplicationInitializer {
	 @Inject 
	 ApplicationInitializer(PersistService service) {
	  service.start(); 
	 }
	}