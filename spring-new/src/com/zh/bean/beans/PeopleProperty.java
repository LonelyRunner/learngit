package com.zh.bean.beans;

import java.util.Properties;

public class PeopleProperty {
	
	private Properties properties;
	
	PeopleProperty(){
		
	}
	
	public PeopleProperty(Properties properties){
		this.properties = properties;
	}
	
	public Properties getProperties(){
		return properties;
	}
	
	public void setProperties(Properties properties){
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "PeopleProperty [properties=" + properties + "]";
	}
}
