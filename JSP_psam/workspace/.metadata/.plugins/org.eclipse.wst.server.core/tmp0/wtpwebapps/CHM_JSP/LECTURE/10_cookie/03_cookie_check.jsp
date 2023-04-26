<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
<%
	Cookie[] cookies = request.getCookies();
%>
	<p> 현재 쿠키의 개수 : <%= cookies.length %>
	<p> 현재 쿠키 목록
	<br>
<%
	for(Cookie cookie : cookies){
%>
		<%= cookie.getName() %> : <%= cookie.getValue() %>
		<br>
<%
	}
%>
	<br>
	<a href="01_cookie_request.jsp">쿠키 만들러 돌아가기</a>
	<br>
	<a href="04_cookie_delete.jsp">쿠키 삭제하기</a>
	<br>
	<a href="05_cookie_update.jsp">쿠키 업데이트하기</a>
	<br>
	<strong>쿠키를 업데이트하면 admin1234로 변경된다.<br>쿠키는 기존의 값이 있어야 업데이트할 수 있다.</strong>
</body>
</html>