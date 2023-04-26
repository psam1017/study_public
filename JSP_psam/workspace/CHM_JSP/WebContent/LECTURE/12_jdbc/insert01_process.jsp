<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
	
String id = request.getParameter("id"); 
String password = request.getParameter("password"); 
String name = request.getParameter("name");

Statement stmt = null;

try{
	String sql = "INSERT INTO member(id, password, name) VALUES ('" + id + "', '" + password + "', '" + name + "')";
	
	out.print(sql);
	
	stmt = conn.createStatement();
	stmt.execute(sql);
	out.print("member 테이블 삽입에 성공했습니다.");
} catch(SQLException e){
	e.printStackTrace();
} finally{
	if(stmt != null){
		stmt.close();
	}
	if(conn != null){
		conn.close();
	}
}
%>