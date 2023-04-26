<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<% response.setStatus(200); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>에러 페이지</title>
</head>
<body>
	<h1>process에서 try ~ catch로 포워딩한 에러 페이지입니다.</h1>
	<%
		if(exception != null){
	%>
	<p> 예외 :  <%= exception %>
	<p> toString() <%= exception.toString() %>
	<p> getClass().getName() <%= exception.getClass().getName() %>
	<p> getMessage() <%= exception.getMessage() %>
	<%
		}
	%>
</body>
</html>