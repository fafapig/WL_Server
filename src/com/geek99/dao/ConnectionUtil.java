package com.geek99.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection open() {
		String url ="jdbc:mysql://localhost:3306/WLDB?useUnicode=true&characterEncoding=gbk";
		String driver = "com.mysql.cj.jdbc.Driver";
		String username = "root";
		String password = "124718";
		try {
			Class.forName(driver);
			return DriverManager.getConnection(url, username, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	public static void close (Connection conn) {
		if(conn!=null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				conn = null;
			}
		}
	}
}
