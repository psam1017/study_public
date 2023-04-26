<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.SQLException" %>
<%@ include file="02.conn_db.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String num = request.getParameter("num");
	String tableName = "todo_list";
	Statement statement = null;
	String sql = "DELETE FROM " + tableName + " WHERE num = " + num;
	
	statement = conn.createStatement();
	int resultInt = statement.executeUpdate(sql);
%>
{"delete" : "true", "num" : "<%=num%>"}
