package com.zh.bean.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	public void save(){
		System.out.println(" µœ÷¿‡...");
	}
}
