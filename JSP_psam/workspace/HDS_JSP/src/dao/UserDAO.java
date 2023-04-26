package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.management.RuntimeErrorException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import vo.UserVO;

//NUM NUMBER PRIMARY KEY,
//ID VARCHAR2(1000),
//NAME VARCHAR2(1000),
//PASSWORD VARCHAR2(1000),
//GENDER VARCHAR2(100),
//ZIPCODE VARCHAR2(100),
//ADDRESS VARCHAR2(1000),
//ADDRESS_DETAIL VARCHAR2(1000),
//ADDRESS_ETC VARCHAR2(1000)

public class UserDAO {
	
	Connection conn; // 외부 저장소인 DBMS를 드라이버를 통해 가져온 연결 객체.
	PreparedStatement pstm; // 문자열 안에 있는 SQL 문을 객체로 저장. 변수가 들어갈 자리(?)에 알맞는 값을 넣어줌. SQL문을 실행시킴.
	ResultSet rs; // SELECT의 결과를 담는 객체
	
	public void join(UserVO user) {
		
		//필요한 SQL문 작성
		String query = "INSERT INTO TBL_USER VALUES(SEQ_USER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			//Connection 객체를 전달 받는다.
			conn = DBConnector.getConnection();
			//작성한 퀴리문을 PreparedStatement에 전달한다.
			pstm = conn.prepareStatement(query);
			//?자리에 알맞는 변수를 전달해준다.
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getPassword());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getZipcode());
			pstm.setString(6, user.getAddress());
			pstm.setString(7, user.getAddress_detail());
			pstm.setString(8, user.getAddress_etc());
			
			//DML 중 INSERT 쿼리를 실행하는 메소드를 사용한다.
			pstm.executeUpdate();
			// executeQuery -> SELECT 문 실행
			// executeUpdate -> SELECT 이외의 문 실행 -> 결과 건수
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // DB 관련 객체 사용 후 연결 끊어서 메모리에서 해제하기
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) { // 메모리에서 unload할 때 문제가 생기면 Runtime 예외를 발생시켜서 프로그램 강제종료
				throw new RuntimeException(e);
			}
		}
	}
	
	// 아이디 중복 검사
	public boolean checkId(String id) {
		String query = "SELECT COUNT(ID) FROM TBL_USER WHERE ID = ?";
		boolean check = false;
		
		try {
			// DBMS 연결 객체 가져오기.
			conn = DBConnector.getConnection();
			// String으로 선언된 쿼리를 pstm 참조변수에 전달하기.
			pstm = conn.prepareStatement(query);
			// SQL 쿼리에 ?가 있다면 알맞는 값으로 지정해주기.
			pstm.setString(1, id);
			// 쿼리 실행 후 결과를 rs에 담기
			rs = pstm.executeQuery();
			
			//행 가져오기(DB에서 데이터를 가져올 때 행을 먼져 가져오고, 그 다음 열을 가져온다. 단일 행 함수를 사용했으므로 행은 하나. -> next() 사용)
			rs.next();
			// 위에서 가져온 행의 열을 타입에 맞춰서 가져오기
			check = rs.getInt(1) == 1; // 0은 중복 없음. 1은 중복 있음.
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally { // DB 관련 객체 사용 후 연결 끊어서 메모리에서 해제하기
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return check;
	}
	
	// 로그인 완료를 위해 DB와 검사
	public boolean login(String id, String pw) {
		String query = "SELECT COUNT(ID) FROM TBL_USER WHERE ID = ? AND PASSWORD = ?";
		boolean check = false;
		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			
			rs = pstm.executeQuery();
			rs.next();
			check = rs.getInt(1) == 1;
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null){
					rs.close();
				}
				if(pstm != null){
					pstm.close();
				}
				if(conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		return check;
	}
}











