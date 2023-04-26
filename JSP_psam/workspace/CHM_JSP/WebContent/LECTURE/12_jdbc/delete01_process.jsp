<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="dbconn.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
	
String id = request.getParameter("id"); 
String password = request.getParameter("password"); 

ResultSet rs = null;
Statement stmt = null;

try{
	String sql = "SELECT id, password FROM `member` WHERE id = '" + id + "'";
	stmt = conn.createStatement();
	rs = stmt.executeQuery(sql);
	
	if (rs.next()){
		String rId = rs.getString("id");
		String rPassword = rs.getString("password");
		
		if(id.equals(rId) && password.equals(rPassword)){
			sql = "DELETE FROM `member` WHERE id = '" + id + "'";
			stmt = conn.createStatement();
			stmt.execute(sql);
			out.print(id + "회원의 데이터를 삭제하였습니다.");
		}
		else{
			out.print("로그인 정보가 잘못되었습니다.");
		}
	}
	else {
		out.print("존재하지 않는 회원입니다.");
	}
} catch(SQLException e){
	e.printStackTrace();
} finally{
	if(rs != null){
		rs.close();
	}
	if(stmt != null){
		stmt.close();
	}
	if(conn != null){
		conn.close();
	}
}
%>