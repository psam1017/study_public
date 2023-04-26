<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 검사</title>
</head>
<body>
	<%
	Cookie cookieId = new Cookie("id", request.getParameter("id"));
	Cookie cookiePw = new Cookie("pw", request.getParameter("pw"));
	
	cookieId.setMaxAge(100);
	cookiePw.setMaxAge(100);
	response.addCookie(cookieId);
	response.addCookie(cookiePw);
	%>
	로그인 성공!
</body>
</html>