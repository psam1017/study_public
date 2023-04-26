package ch34_database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Step5_SelectUser {
	public static void main(String[] args) throws SQLException{
		
		DBSelect myDB = new DBSelect();
		myDB.connectDB();
		String sql = "SELECT * FROM user";
		myDB.printUserAll(sql);
		myDB.printUserOne();
		myDB.closeDB();
	}
}

class DBSelect extends DB{
	
	public ResultSet querySelect(String sql){
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		} catch(SQLException e) {
			System.out.println("error : " + e);
		}
		return rs;
	}
	
	// ResultSet 반환이 여러 개일 경우 while 반복문을 사용한다.
	public void printUserAll(String sql) throws SQLException{
		
		ResultSet rs = querySelect(sql);
		int num = 1;
		
		System.out.println();
		while(rs.next()) {
			System.out.println(num + "번째 회원");
			System.out.println("아이디 : " + rs.getString(1));
			System.out.println("이름 : " + rs.getString(2));
			System.out.println("나이 : " + rs.getString(3));
			System.out.println("직업 : " + rs.getString(4));
			System.out.println();
			num++;
		}
	}
	
	// ResultSet 반환이 하나인 경우 if 조건문을 사용해도 된다.
	public void printUserOne() throws SQLException{
		
		String sql;
		String id;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("검색할 회원의 아이디를 입력하세요 : ");
		id = sc.next();
		sc.close();
		sql = "SELECT * FROM user WHERE id = '" + id + "'";
		
		ResultSet rs = querySelect(sql);
		
		if(rs.next()) {
			System.out.println("아이디 : " + rs.getString(1));
			System.out.println("이름 : " + rs.getString(2));
			System.out.println("나이 : " + rs.getString(3));
			System.out.println("직업 : " + rs.getString(4));
		}
	}
}
