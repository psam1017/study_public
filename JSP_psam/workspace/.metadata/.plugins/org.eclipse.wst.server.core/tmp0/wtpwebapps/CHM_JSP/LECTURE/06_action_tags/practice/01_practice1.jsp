<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 실습</title>
</head>
<body>
	<jsp:forward page="practice.jsp">
		<jsp:param value="5" name="number"/>
	</jsp:forward>
</body>
</html>