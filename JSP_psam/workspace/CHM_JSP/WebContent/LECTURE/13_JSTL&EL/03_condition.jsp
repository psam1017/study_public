<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="_13_jstl_el.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>condition</title>
</head>
<body>
	<c:set var="num" value="${10}"/>
	
	<p>
	<c:if test="${ num > 6 }">
		합격입니다.
	</c:if>
	
	<p>
	<c:choose>
		<c:when test="${num >= 9}">A입니다.</c:when>
		<c:when test="${num >= 7}">B입니다.</c:when>
		<c:when test="${num >= 5}">C입니다.</c:when>
		<c:otherwise>낙제입니다.</c:otherwise>
	</c:choose>
</body>
</html>