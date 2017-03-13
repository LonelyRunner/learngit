package com.zh.service;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.zh.dao.UserRestDao;
import com.zh.demo.User;

@Path("/userService")
public class UserRestService {
	
	private UserRestDao userRestDao = new UserRestDao();
//	
//	@Inject
//	public UserRestService(UserRestDao userRestDao){
//		this.userRestDao = userRestDao;
//	}
	
	@GET
	@Path("/getUserText")
	@Produces(MediaType.APPLICATION_JSON)
	public String getUserText(){
		return "Hello world";
	}
	
	@GET
	@Path("/getUser")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersList() throws Exception{
		List<User> list = userRestDao.getUsersList();
		return list;
	}
	
	@POST
	@Path("/saveUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void saveUser(User user) throws Exception{
		userRestDao.saveUser(user);
	}
	
	@POST
	@Path("/deleteSelectedUser")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUserByName(User user) throws Exception{
		userRestDao.deleteUserByName(user.getName());
	}
}
