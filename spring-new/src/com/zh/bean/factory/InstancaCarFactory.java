package com.zh.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class InstancaCarFactory {
	
	private Map<String,Car> map = null;
	
	public InstancaCarFactory(){
		map = new HashMap<String,Car>();
		map.put("AA", new Car("Audi",300000));
		map.put("BB", new Car("ford",400000));
	}
	
	public Car getCar(String name){
		return map.get(name);
	}

}
