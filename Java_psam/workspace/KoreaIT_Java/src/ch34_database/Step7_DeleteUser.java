package ch34_database;

import java.sql.SQLException;

public class Step7_DeleteUser {
	public static void main(String[] args) {
		
		DBDelete myDB = new DBDelete();
		myDB.connectDB();
		myDB.deleteUser("002");
		myDB.closeDB();
	}
}

class DBDelete extends DB{
	
	// ID를 입력받아 유저를 삭제할 수 있는 SQL문을 실행
	public boolean deleteUser(String id) {
		
		String sql = "DELETE FROM sample.user "
				   + " WHERE id = '"+id+"'";
		
		int count = 0;
		// sql확인
		System.out.println("실행된 sql : " + sql);
		
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

