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
		out.print(request.getQueryString());
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
	%>
	<p>id : <%= id %></p>
	<p>pw : <%= pw %></p>
</body>
</html>