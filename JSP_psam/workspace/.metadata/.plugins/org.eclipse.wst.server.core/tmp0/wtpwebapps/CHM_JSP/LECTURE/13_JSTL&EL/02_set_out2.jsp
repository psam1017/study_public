<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="_13_jstl_el.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set and out</title>
</head>
<body>
	<p> header의 값 받아와서 설정 후 출력 <br>
	<c:set var="header" value="${header['User-Agent']}"/>
	<c:out value="${header}"/><br>
	
	<p> header의 값 삭제 후 출력 <br>
	<c:remove var="header"/>
	<c:out value="${header}"/><br>
	
	<br><br><br>
	<p> header의 값은 사라지지 않는다.
</body>
</html>