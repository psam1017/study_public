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
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id.equals(pw)){
		response.addCookie(new Cookie("id", id));
		response.addCookie(new Cookie("pw", pw));
		out.print("쿠키를 생성했습니다.<br>");
		out.print(id + "님 환영합니다.");
%>
		<br>
		<a href="03_cookie_check.jsp">쿠키 확인하기</a>
		<br>
		<a href="04_cookie_delete.jsp">쿠키 삭제하기</a>
<%
	}
	else{
		out.print("쿠키를 생성하지 못 했습니다.");
	}
%>
</body>
</html>