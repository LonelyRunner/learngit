package com.zh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import com.zh.demo.User;

import jersey.repackaged.com.google.common.collect.Lists;

public class UserRestDao {
	
	public List<User> getUsersList() throws Exception{
		List<User> userList = Lists.newArrayList();
		Connection conn = DataBaseInfo.getConnection();
		String sql = "select * from jersey_user";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()){
			User user = new User();
			user.setName(rs.getString("name"));
			user.setAge(rs.getString("age"));
			user.setGender(rs.getString("gender"));
			userList.add(user);
		}
		return userList;
	}
	

	public void saveUser(User user) throws Exception{
		Connection conn = DataBaseInfo.getConnection();
		String sql = "insert into jersey_user values (?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getAge());
		ps.setString(3, user.getAge());
		ps.executeQuery();
		conn.commit();
		if(conn!=null){
			conn.close();
		}
	}
	
	public void deleteUserByName(String name) throws Exception{
		Connection conn = DataBaseInfo.getConnection();
		String sql = "delete jersey_user ju where ju.name=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.executeQuery();
		conn.commit();
		if(conn!=null){
			conn.close();
		}
	}
	
//	public static void main(String[] args) {
//		try {
//			List<User> userList = getUsersList();
//			System.out.println(userList);
//			for(User user : userList){
//				System.out.println(user);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
