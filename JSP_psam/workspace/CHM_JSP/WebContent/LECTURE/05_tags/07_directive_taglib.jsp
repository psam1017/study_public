<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>디렉티브 태그</title>
</head>
<body>
	<!-- 빌드패스, WEB-INF - lib에 삽입, taglib 선언 -->
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"/>
	</c:forEach>
</body>
</html>