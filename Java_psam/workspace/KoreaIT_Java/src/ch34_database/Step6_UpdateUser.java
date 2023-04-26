package ch34_database;

import java.sql.SQLException;

public class Step6_UpdateUser {
	public static void main(String[] args) {
		
		DBUpdate myDB = new DBUpdate();
		myDB.connectDB();
		myDB.updateUserAge("001", 27);
		myDB.closeDB();
	}
}

class DBUpdate extends DB{
	
	// 나이 변경만 가능한 SQL 문을 실행
	public boolean updateUserAge(String id,int age) {
		
		String sql = "UPDATE sample.user "
				   + " SET age = " + age + " "
				   + " WHERE id = '"+id+"'";
		
		int count = 0;
		// sql확인
		System.out.println("sql= " + sql);
		
		// 데이터 수정하는 sql
		try {
			pstmt = conn.prepareStatement(sql);
			count = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return count > 0? true : false ;
	}
}
