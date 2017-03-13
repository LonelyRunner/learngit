package com.zh;

import org.glassfish.jersey.filter.LoggingFilter;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class ApplicationTest extends ResourceConfig{
	public ApplicationTest(){
		packages("com.zh.service");
		register(JacksonJsonProvider.class);
		register(LoggingFilter.class);
	}
}
