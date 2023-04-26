<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴</title>
</head>
<body>
<%
String sessionId = (String)session.getAttribute("sessionId");
%>
<sql:setDataSource
	var="dataSource"
	url="jdbc:mariadb://localhost:12601/sample"
	driver="org.mariadb.jdbc.Driver"
	user="root"
	password="test1234"
/>
<sql:update dataSource="${dataSource}" var="resultSet">
	DELETE FROM `member` WHERE id = ?
	<sql:param value="<%=sessionId%>" />
</sql:update>

<c:if test="${resultSet >= 1}">
	<c:import var="url" url="logoutMember.jsp" />
	<c:redirect url="resultMember.jsp" />
</c:if>

</body>
</html>