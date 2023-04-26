<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.LoginBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
	<%
		LoginBean bean = (LoginBean) request.getAttribute("bean");
	%>
	<p> 아이디 : <%= bean.getId() %>
</body>
</html>