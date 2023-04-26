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
	<c:set var="name" value="Amy"/>
	<c:out value="${name}"/><br>
	
	<c:remove var="name"/>
	<c:out value="${name}"/><br>
	
	<hr>
	
	<%
		BookBean bookBean = new BookBean("Title", "Author", null);
		request.setAttribute("bookOne",	bookBean);
	%>
	
	<c:set var="title" value="${bookCon.title }"/>
	<c:out value="${title}"/><br>
	
	<c:set var="author" value="${bookCon.getAhtuor() }"/>
	<c:out value="${author}">값이 null일 때 기본값</c:out><br>
	
	<hr>
	
	<c:set var="name">Tomcat</c:set>
	<c:out value=${name }/><br>
	
</body>
</html>