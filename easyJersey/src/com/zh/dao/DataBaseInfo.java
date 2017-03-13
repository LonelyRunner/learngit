package com.zh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.zh.demo.User;

import jersey.repackaged.com.google.common.collect.Lists;

/**
 * 获取数据库相关信息
 * @author ZH
 *
 */
public class DataBaseInfo {
	private static String userName = "briup";
	private static String password = "briup";
	private static String driverName = "oracle.jdbc.driver.OracleDriver";
	private static String urlName = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static Connection conn;
	
	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(driverName);
		conn = DriverManager.getConnection(urlName,userName,password);
		return conn;
	}
	
//	public List<User> getUsersList() throws Exception{
//		List<User> userList = Lists.newArrayList();
//		Connection conn = DataBaseInfo.getConnection();
//		String sql = "select * from jersey_user";
//		Statement st = conn.createStatement();
//		ResultSet rs = st.executeQuery(sql);
//		System.out.println(rs);
//		while(rs.next()){
//			User user = new User();
//			user.setName(rs.getString("name"));
//			System.out.println(rs.getString("name"));
//			user.setAge(rs.getString("age"));
//			user.setGender(rs.getString("gender"));
//			userList.add(user);
//		}
//		return userList;
//	}
	
//	public static void main(String[] args) throws Exception{
//		System.out.println("-------------------");
//		try {
//			List<User> userList = getUsersList();
//			System.out.println(userList);
//			for(User user : userList){
//				System.out.println(user);
//			}
//			System.out.println("-------------------");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
