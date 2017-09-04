package com.zh.bean.annotation.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserORepositoryImpl implements UserRepository{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("ershixiong~~~");
	}

}
