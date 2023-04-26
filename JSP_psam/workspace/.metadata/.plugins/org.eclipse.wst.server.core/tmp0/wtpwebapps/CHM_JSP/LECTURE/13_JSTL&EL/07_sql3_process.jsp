<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sql</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		request.setAttribute("id", id);
		request.setAttribute("password", password);
		request.setAttribute("name", name);
	%>
	<sql:setDataSource
		var="dataSource"
		url="jdbc:mariadb://localhost:12601/sample"
		driver="org.mariadb.jdbc.Driver"
		user="root"
		password="test1234"
	/>
	
	<sql:update dataSource="${dataSource}" var="resultSet">
		UPDATE `member` SET name = ? WHERE id = ? AND password = ?
		<sql:param value="${name}"/>
		<sql:param value="${id}"/>
		<sql:param value="${password}"/>
	</sql:update>
	
	<c:import var="url" url="05_sql1.jsp"/>
	${url}
	<%-- c:out으로 url을 출력하면 소스코드를 그대로 보여주게 된다(그래서 JSTL을 쓰는 것). --%>
</body>
</html>