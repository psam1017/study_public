<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Test</title>
</head>
<body>
	<h1>JSTL 변수</h1>
	<c:set var="name" value="박성민" scope="page"></c:set>
	<c:out value="${name}"></c:out>
	<br>
	<c:out value="\${name}"></c:out>
	
	<hr>
	
	<c:set var="nation" scope="session">Korea</c:set>
	<c:remove var="nation" scope="session"/>
	<c:out value="${nation}" default="한국"></c:out>
	
	<c:set var="data1" value="10"></c:set>
	<c:set var="data2" value="${20}"></c:set>
	<c:set var="data3">30.5</c:set>
	<c:out value="${ data1 + data2 + data3 }"></c:out>
</body>
</html>