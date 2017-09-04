package com.zh.bean.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

public class BaseService<T> {

	@Autowired
	protected BaseRepository<T> baseRepository;
	
	public void save(){
		System.out.println("save ... ");
		System.out.println(baseRepository);
	}
}
