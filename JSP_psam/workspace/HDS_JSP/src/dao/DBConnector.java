package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
	
	public static Connection getConnection() {
		
		//DAO에서 모든 메소드에 필요한 DB 연결 문법을 미리 메소드에 선언해 놓는다. -> 재사용성 Up
		Connection conn = null;
		
		try {
			//DB연결을 위한 정보를 입력한다(url, username, password).
			String url = "jdbc:oracle:thin:@localhost:1521:XE"; // DB 연결 같은 부분은 실무에서 대부분 이미 구축되어있으므로 부담을 가질 필요는 없다.
			String user = "hr";
			String pw = "hr";
			
			//드라이버를 메모리에 할당한다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//입력한 정보를 전달하여 드라이버를 통해 연결 객체를 가져온다.
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
