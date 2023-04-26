<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="02.conn_db.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String item = request.getParameter("item");
	
	String tableName = "todo_list";
	int num = 0;
	Statement statement = null;
	
	String sql = "INSERT INTO " + tableName + "(item, insertDate) VALUES('" + item + "', NOW())";
	
	statement = conn.createStatement();
	statement.executeUpdate(sql);
	
	// getGeneratedKeys()가 안 돼서 최신글을 들고 오도록 수정
	// ResultSet getGeneratedKeys = statement.getGeneratedKeys();
	// out.print(getGeneratedKeys.getInt(1));
	// 저장된 글의 번호를 들고 옴. 삭제 시 데이터의 식별을 위해서.
	sql = "SELECT num FROM " + tableName + " ORDER BY num DESC LIMIT 0, 1";
	ResultSet resultSet = statement.executeQuery(sql);
	if(resultSet.next()){
		num = resultSet.getInt(1);
	}
	
	if(statement != null){
		statement.close();
	}
	if(conn != null){
		conn.close();
	}
%>
{"insert" : "true", "num" : "<%=num%>"}
