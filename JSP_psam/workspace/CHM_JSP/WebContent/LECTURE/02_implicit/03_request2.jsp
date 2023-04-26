<%@page import="java.util.Enumeration"%>
<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Implicit Objects - request</title>
</head>
<body>
	<%
		Enumeration<String> en = request.getHeaderNames();
		while(en.hasMoreElements()){
			String headerName = (String)en.nextElement();
			String headerValue = request.getHeader(headerName);
			out.print(headerName + " : ");
			out.print(headerValue + "<br>");
		}
	%>
	<!--
		out.print 사용을 자제하고 표현문 태그를 사용하는 이유
		표현문 태그를 사용하여 데이터 하나하나씩 분리하면 프론트와 협업할 때, 프론트에서도 데이터를 조작하기 쉬워진다.
	-->
</body>
</html>
