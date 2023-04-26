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

	if(cookies != null && cookies.length > 0){
		for(Cookie cookie : cookies){
			if(cookie.getName().equals("id")){
				cookie = new Cookie("id", "admin1234");
				response.addCookie(cookie);
			}
			else if(cookie.getName().equals("pw")){
				cookie = new Cookie("pw", "admin1234");
				response.addCookie(cookie);
			}
		}
	}
	
	response.sendRedirect("03_cookie_check.jsp");
%>
</body>
</html>