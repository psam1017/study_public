<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
	
String id = request.getParameter("id"); 
String password = request.getParameter("password"); 
String name = request.getParameter("name");

PreparedStatement pstmt = null;

try{
	String sql = "INSERT INTO member(id, password, name) VALUES (?, ?, ?)";
	pstmt = conn.prepareStatement(sql);
	
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	pstmt.setString(3, name);
	pstmt.executeUpdate();
	out.print("member 테이블 삽입에 성공했습니다.");
} catch(SQLException e){
	e.printStackTrace();
} finally{
	if(pstmt != null){
		pstmt.close();
	}
	if(conn != null){
		conn.close();
	}
}
%>