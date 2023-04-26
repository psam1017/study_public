<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>응답 페이지</title>
</head>
<body>
	<!-- 이름 전달 받기 -->
	<%
	String name = request.getParameter("name");
	%>
	
	<!-- 전달 받은 이름을 다시 05_request_test.jsp로 전달 -->
	<h1>요청 페이지</h1>
	<form action="05_request_test.jsp">
		<input type="text" name="name" value="<%= name %>">
		<button>전송</button>
	</form>
	
	<!-- 전달 받은 이름을 Redirect로 보내기 -->
	<%
	response.sendRedirect("05_request_test.jsp?name=" + URLEncoder.encode(name, "UTF-8"));
	%>
</body>
</html>