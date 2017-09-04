package com.zh.bean.annotation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.zh.bean.annotation.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	@Qualifier("userRepositoryImpl")
	private UserRepository userRepository;

	public void execute(){
		System.out.println("~~~~~~~~~~~~~~");
		userRepository.save();
	}
}
