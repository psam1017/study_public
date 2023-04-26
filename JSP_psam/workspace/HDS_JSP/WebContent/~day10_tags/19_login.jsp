<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<jsp:forward page="20_loginP.jsp">
		<jsp:param value="psam1017" name="id"/>
		<jsp:param value="qwer1234" name="pw"/>
	</jsp:forward>
</body>
</html>