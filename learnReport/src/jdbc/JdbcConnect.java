package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnect {
	private static String dirverName = "oracle.jdbc.driver.OracleDriver";
	private static String urlName = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static String userName = "briup";
	private static String password = "briup";
	private static Connection connection;
	
	public static Connection getConnection() 
			throws ClassNotFoundException,SQLException{
		Class.forName(dirverName);
		connection = DriverManager.getConnection(urlName,userName,password);
		return connection;
	}
}
