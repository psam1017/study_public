<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>EX05</title>
</head>
<body>
<h1>EX05 페이지입니다</h1>
<p> 이름 : <c:out value="${infoDTO.name}"/></p>
<p> 나이 : <c:out value="${infoDTO.age}"/></p>
<p> 성별 : <c:out value="${gender}"/></p>
</body>
</html>
