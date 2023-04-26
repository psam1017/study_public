<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects - response</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(id.equals("admin") && password.equals("1234")){
			response.sendRedirect("07_response1_success.jsp");
		}
		else{
			response.sendRedirect("08_response1_fail.jsp");
		}
	%>
</body>
</html>