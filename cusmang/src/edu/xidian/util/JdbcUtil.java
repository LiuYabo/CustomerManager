package edu.xidian.util;

import java.sql.Connection;




import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	
	public static Properties prop = new Properties();
	static {
		try {
			prop.load(JdbcUtil.class.getClassLoader().getResourceAsStream("db.properties"));
			Class.forName(prop.getProperty("driver"));
		} catch (Exception e) {
			throw new ExceptionInInitializerError (e);  //若无法创建连接则系统出错，直接抛出异常
		}
		
		
	}
	
	public static Connection getConnection() throws Exception {
		String url = prop.getProperty("url");
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		Connection conn = DriverManager.getConnection(url, username, password);
		return conn;
	}
	
	public static void close(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
	}

}
