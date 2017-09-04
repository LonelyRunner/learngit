package com.zh.bean.factory;

import java.util.HashMap;
import java.util.Map;

public class StaticCarFactory {
	
	private static Map<String,Car> map = new HashMap<String,Car>();
	
	static{
		map.put("audi",new Car("Audi",200000));
		map.put("ford",new Car("ford",300000));
	}
	
	public static Car getCar(String key){
		return map.get(key);
	}
}
