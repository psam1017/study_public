<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p> servlet context message : <c:out value="${msg}">Servlet Context Event가 발생하지 않았습니다.</c:out>
	<p> servlet context attribute : <c:out value="${name}">Servlet Context에 Attribute가 추가되지 않았습니다.</c:out>
	<p> session attribute : <c:out value="${id}">Session에 Attribute가 추가되지 않았습니다.</c:out>
</body>
</html>