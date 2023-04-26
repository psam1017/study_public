<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Student</title>
</head>
<body>

<c:set var="total" value="${student.kor + student.eng + student.math}"></c:set>
<c:set var="avg" value="${(total / 3)}"></c:set>

<h1>점수 정보</h1>
<table border="1">
	<tr>
		<th>번호</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>총점</th>
		<th>평균</th>
	</tr>
	<tr>
		<td><c:out value="${student.num}"></c:out></td>
		<td><c:out value="${student.kor}"></c:out></td>
		<td><c:out value="${student.eng}"></c:out></td>
		<td><c:out value="${student.math}"></c:out></td>
		<td><c:out value="${total}"></c:out></td>
		<td><c:out value="${avg}"></c:out></td>
	</tr>
</table>
</body>
</html>
