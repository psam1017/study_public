package ch31_design_pattern.mvc.libraryDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookConnection {
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
		} catch(ClassNotFoundException e) {
				System.out.println("드라이버 로드 실패!");
				e.printStackTrace();
		} catch(SQLException e) {
				System.out.println("SQL 예외!");
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
			}
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void addBook(BookData data) {
		
		String insertSQL = "INSERT INTO TBL_BOOK(bookCode, title, author, originStock, currentStock) VALUES (?, ?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, data.getCode());
			pstmt.setString(2, data.getTitle());
			pstmt.setString(3, data.getAuthor());
			pstmt.setInt(4, data.getStockOrigin());
			pstmt.setInt(5, data.getStockCurrent());
			int row = pstmt.executeUpdate();
			
			if(row == 1) {
				System.out.println("데이터 입력에 성공했습니다.");
			}
			else {
				System.out.println("데이터 입력에 실패했습니다.");
			}
		} catch (SQLException e) {
			System.out.println("올바르지 않은 값이 입력되었습니다.");
			System.out.println("다시 시도해주세요.");
		}
	}
	
	public void searchBook(String title) {
		String searchSQL = "SELECT * FROM TBL_BOOK WHERE title LIKE('%" + title + "%')";
		
		try {
			pstmt = conn.prepareStatement(searchSQL);
			rs = pstmt.executeQuery();
			boolean isBookOk = false;
			
			while(rs.next()) {
				System.out.println("==============================");
				System.out.println("코드 : " + rs.getString(1));
				System.out.println("제목 : " + rs.getString(2));
				System.out.println("저자 : " + rs.getString(3));
				System.out.println("원 재고 : " + rs.getInt(4));
				System.out.println("현재 재고 : " + rs.getInt(5));
				isBookOk = true;
			}
			
			if(!isBookOk) {
				System.out.println(title + "제목을 가진 책을 찾지 못 했습니다.");
			}
		} catch (SQLException e) {
			System.out.println("도서 조회 오류 발생");
			e.printStackTrace();
		}
	}
	
	public int checkStock(String code) {
		
		int stock = 0;
		
		String checkSQL = "SELECT currentStock FROM TBL_BOOK WHERE bookCode = " + code;
		
		try {
			pstmt = conn.prepareStatement(checkSQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				stock = rs.getInt(1);
			}
			else {
				System.out.println("해당 코드를 가진 도서가 존재하지 않습니다.");
				System.out.println("코드를 확인한 후 다시 이용해주십시오.");
				stock = -1;
			}
		} catch (SQLException e) {
			System.out.println("도서 권수 조회 오류 발생");
			e.printStackTrace();
		}
		
		return stock;
	}	
	
	public int checkOrigin(String code) {
		
		int origin = 0;
		
		String checkSQL = "SELECT originStock FROM TBL_BOOK WHERE bookCode = " + code;
		
		try {
			pstmt = conn.prepareStatement(checkSQL);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				origin = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("도서 권수 조회 오류 발생");
			e.printStackTrace();
		}
		
		return origin;
	}
	
	public void lendBook(String code, int num) {
		
		num = checkStock(code) - num;
		String lendSQL = "UPDATE TBL_BOOK SET currentStock = ? WHERE bookCode = ?";
		
		try {
			pstmt = conn.prepareStatement(lendSQL);
			pstmt.setInt(1, num);
			pstmt.setString(2, code);
			pstmt.executeUpdate();
			
			System.out.println("이용해주셔서 감사합니다.");
		} catch (SQLException e) {
			System.out.println("도서 대여 예외 발생");
			e.printStackTrace();
		}
	}
	
	public void returnBook(String code, int num) {
		
		num = checkStock(code) + num;
		String lendSQL = "UPDATE TBL_BOOK SET currentStock = ? WHERE bookCode = ?";
		
		try {
			pstmt = conn.prepareStatement(lendSQL);
			pstmt.setInt(1, num);
			pstmt.setString(2, code);
			pstmt.executeUpdate();
			
			System.out.println("이용해주셔서 감사합니다.");
		} catch (SQLException e) {
			System.out.println("도서 대여 예외 발생");
			e.printStackTrace();
		}
	}
	
	public void getList() {
		String searchSQL = "SELECT * FROM TBL_BOOK";
		
		try {
			pstmt = conn.prepareStatement(searchSQL);
			rs = pstmt.executeQuery();
			boolean isBookOk = false;
			
			while(rs.next()) {
				System.out.println("==============================");
				System.out.println("코드 : " + rs.getString(1));
				System.out.println("제목 : " + rs.getString(2));
				System.out.println("저자 : " + rs.getString(3));
				System.out.println("원 재고 : " + rs.getInt(4));
				System.out.println("현재 재고 : " + rs.getInt(5));
				isBookOk = true;
			}
			
			if(!isBookOk) {
				System.out.println("도서 목록이 비어있습니다. 책을 넣어주세요.");
			}
		} catch (SQLException e) {
			System.out.println("도서 조회 오류 발생");
			e.printStackTrace();
		}
	}
}
