package com.zh.bean.annotation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.zh.bean.annotation.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService uerService;
	
	public void uc(){
		System.out.println("--------------");
		uerService.execute();
	}
}
