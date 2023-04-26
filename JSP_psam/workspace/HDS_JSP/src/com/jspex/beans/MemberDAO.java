package com.jspex.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MemberDAO {
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	public ArrayList<MemberVO> select(String name) {
		String query = "SELECT * FROM TBL_MEMBER WHERE NAME = ?"; // ? 부분을 채우기 위해 Connection과 PreparedStatement를 사용해야 한다.
		ArrayList<MemberVO> members = new ArrayList<>();
		MemberVO member = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd"); // DATE 타입인 birthday를 String으로 바꾸기 위해 사용해야 한다.
		
		try {
			conn = DBConnector.getConnection();
			pstm = conn.prepareStatement(query);
			pstm.setString(1, name); // 0이 아니라 1부터 시작한다.
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				member = new MemberVO();
				member.setNum(rs.getInt(1));
				member.setName(rs.getString(2));
				member.setBirthday(sdf.format(rs.getDate(3)));
				
				members.add(member);
			}
		} catch (SQLException e) {
			System.out.println("SELECT(String) Query Failed" + e);
		} catch (Exception e) {
			System.out.println("Unknown Error Occured : " + e);
		} finally { // 열었던 순서의 반대로 종료해야 한다.
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
				throw new RuntimeException(e.getMessage()); // 메모리에 데이터가 계속 남아있지 못 하도록 강제종료.
			}
		}
		return members;
	}
}
