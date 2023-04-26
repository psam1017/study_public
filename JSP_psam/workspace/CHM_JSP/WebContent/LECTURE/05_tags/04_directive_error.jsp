<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그</title>
</head>
<body>
	<%@ page errorPage="error.jsp"%>
	<%! String string = null;%>
	<%= string.toString()%>
</body>
</html>