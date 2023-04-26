<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="_13_jstl_el.BookBean" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loop</title>
</head>
<body>

	<c:forEach var="i" begin="1" end="10" step="2">
		<c:out value="${i}"/>
	</c:forEach>
	
	<hr>
	
	<%
		ArrayList<BookBean> bookList = new ArrayList<>();
		bookList.add(new BookBean("T1", "A1", "P1"));
		bookList.add(new BookBean("T2", "A2", "P2"));
		request.setAttribute("bookList", bookList);
	%>
	
	<c:forEach items="${bookList}" var="item">
		<c:out value="${item.title }"/>
		<c:out value="${item.author }"/>
		<c:out value="${item.publisher }"/>
		<br>
	</c:forEach>

</body>
</html>