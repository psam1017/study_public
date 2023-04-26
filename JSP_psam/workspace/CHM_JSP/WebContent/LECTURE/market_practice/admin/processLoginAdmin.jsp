<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ include file="../dbconn.jsp" %>

<%
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id");
	String password = request.getParameter("password");
%>

<sql:setDataSource
	var="dataSource"
	url="jdbc:mariadb://localhost:12601/sample"
	driver="org.mariadb.jdbc.Driver"
	user="root"
	password="test1234"
/>

<%
	String sql = "SELECT * FROM admin WHERE id = ? AND password = ?";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, id);
	pstmt.setString(2, password);
	rs = pstmt.executeQuery();
	
	if(rs.next()){
		session.setAttribute("sessionAdminId", rs.getString("id"));
		session.setAttribute("sessionAdminName", rs.getString("name"));
		session.setAttribute("sessionAdminDay", rs.getString("lately_login_day"));
		
		sql = "UPDATE amdin SET lately_log_day = NOW() WHERE id = ? AND password = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
		
		response.sendRedirect("index.jsp");
	}
	else{
		response.sendRedirect("loginAdmin.jsp?error=1");
	}
%>
