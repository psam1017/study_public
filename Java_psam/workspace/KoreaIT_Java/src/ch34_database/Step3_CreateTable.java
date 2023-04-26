package ch34_database;

public class Step3_CreateTable {
	public static void main(String[] args) {
		
		DBCreate myDB = new DBCreate();
		myDB.connectDB();
		
		String sql = "CREATE TABLE user("
						+ "id VARCHAR(100) COLLATE utf8_general_ci, "
						+ "name VARCHAR(100) COLLATE utf8_general_ci, " 
						+ "age INT, "
						+ "job VARCHAR(100) COLLATE utf8_general_ci" 
					+ ")";
		
		myDB.createTable("user", sql);
		myDB.closeDB();
	}
}

class DBCreate extends DB{
	
	public void createTable(String tableName, String sql) {
		try {
			String tableSql = "show tables";
			boolean isTable = false;
			
			// pstmt = conn.prepareStatement(tableSql);
			// rs = pstmt.executeQuery();
			rs = conn.prepareStatement(tableSql).executeQuery();
			
			while(rs.next()) {
				if(tableName.equals(rs.getString(1))) {
					isTable = true;
				}
			}
			
			if(isTable == true) {
				System.out.println(tableName + " 테이블이 이미 존재합니다.");
			}
			else {
				// pstmt = conn.prepareStatement(sql);
				// rs = pstmt.executeQuery();
				rs = conn.prepareStatement(sql).executeQuery();
				
				if(rs != null) {
					System.out.println(tableName + "테이블 생성에 성공했습니다.");
				}
				else {
					System.out.println(tableName + "테이블 생성에 실패했습니다.");
				}
			}
		} catch(Exception e) {
				System.out.println("테이블 생성 예외 발생 : " + e);
		}
	}
}