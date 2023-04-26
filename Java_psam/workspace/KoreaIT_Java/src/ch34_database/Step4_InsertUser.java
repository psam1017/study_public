package ch34_database;

import java.sql.SQLException;
import java.util.Scanner;

public class Step4_InsertUser {
	public static void main(String[] args) throws SQLException {
		
		DBInsert myDB = new DBInsert();
		myDB.connectDB();
		myDB.insertUser();
		myDB.closeDB();
	}
}

class User{
	public String userID;
	public String name;
	public int age;
	public String job;
}

class DBInsert extends DB{
	
	private User setUser() {
		
		User user = new User();
		Scanner sc = new Scanner(System.in);
		
		boolean validate = false;
		String validateTemp;
		do {
			System.out.print("신규 회원의 아이디를 입력하세요 : ");
			user.userID = sc.nextLine();
			System.out.print("신규 회원의 이름을 입력하세요 : ");
			user.name = sc.nextLine();
			System.out.print("신규 회원의 나이를 입력하세요 : ");
			user.age = Integer.parseInt(sc.nextLine());
			System.out.print("신규 회원의 직업을 입력하세요 : ");
			user.job = sc.nextLine();
			
			System.out.println("신규 회원 : " + user.userID + " / " + user.name
					+ " / " + user.age + " / " + user.job + "이 맞습니까? (Y / N)");
			validateTemp = sc.nextLine();
			
			if (validateTemp.equals("Y") || validateTemp.equals("y")) {
				validate = false;
			}
		} while (validate);
		
		sc.close();
		return user;
	}
	
	public void insertUser() throws SQLException{
		
		User user = setUser();
		String insertSQL = "INSERT INTO user(id, name, age, job) VALUES (?, ?, ?, ?)";
		
		pstmt = conn.prepareStatement(insertSQL);
		pstmt.setString(1, user.userID); // ?의 1번째 값.
		pstmt.setString(2, user.name);
		pstmt.setInt(3, user.age);
		pstmt.setString(4, user.job);
		int row = pstmt.executeUpdate();
		
		if(row == 1) {
			System.out.println("데이터 입력에 성공했습니다.");
		}
		else {
			System.out.println("데이터 입력에 실패했습니다.");
		}
	}
}
