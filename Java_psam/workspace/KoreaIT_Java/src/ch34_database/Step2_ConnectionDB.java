package ch34_database;

import java.sql.*;

public class Step2_ConnectionDB {
	
/*
java.sql �뙣�궎吏�媛� �젣怨듯븯�뒗 Connection 媛앹껜瑜� �궗�슜.
Connection 媛앹껜�뒗 �뿭�떆 ajva.sql �뙣�궎吏��뿉 �룷�븿�릺�뼱 �엳�뒗 DriverManager �겢�옒�뒪�쓽 getConnection() 硫붿냼�뱶瑜� �궗�슜.
getConnection(String url, String user, String password) 硫붿냼�뱶�뒗 static 硫붿냼�뱶濡쒖꽌
url�� �꽌踰꾩쓽 �뜲�씠�꽣踰좎씠�뒪 �쐞移섎�� �굹���궡怨�, user�뒗 �궗�슜�옄 �젒�냽 �븘�씠�뵒, password�뒗 �젒�냽 鍮꾨�踰덊샇瑜� 吏��젙�븳�떎.
*/
	public static void main(String[] args) {
		DB myDB = new DB();
		myDB.connectDB();
		myDB.closeDB();
	}
}

class DB{
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	public void connectDB() {
		final String driver = "org.mariadb.jdbc.Driver";
		final String DB_HOST = "127.0.0.1";
		final String DB_PORT = "12601";
		final String DB_NAME = "sample";
		
		final String DB_URL = "jdbc:mariadb://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
		final String DB_USER = "root";
		final String DB_PASS = "test1234";
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			if(conn != null) {
				System.out.println("DB �젒�냽 �꽦怨�!");
			}
		} catch(ClassNotFoundException e) {
				System.out.println("�뱶�씪�씠踰� 濡쒕뱶 �떎�뙣!");
				e.printStackTrace();
		} catch(SQLException e) {
				System.out.println("SQL �삁�쇅!");
				e.printStackTrace();
		}
	}
	
	public void closeDB() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB �젒�냽 �빐�젣");
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
