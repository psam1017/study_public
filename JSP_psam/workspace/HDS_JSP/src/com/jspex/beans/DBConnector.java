package com.jspex.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			String host = "localhost";
			String portNum = "1521";
			String dbName = "XE";
			String url = "jdbc:oracle:thin:@" + host + ":" + portNum + ":" + dbName;
			String user = "hr";
			String pw = "hr";
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 드라이버를 메모리에 로딩시키는 메소드
			conn = DriverManager.getConnection(url, user, pw); // DriverManager를 통해 커넥션 객체를 가져올 수 있음.
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading Failed");
		} catch(SQLException e) {
			System.out.println("DB Connection Failed");
		} catch(Exception e) {
			System.out.println("Unknown Error Occured : " + e);
		}
		return conn;
	}
}
