<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 실습</title>
</head>
<body>
	<jsp:include page="/LECTURE/06_action_tags/practice.jsp">
		<jsp:param value="5" name="number"/>
	</jsp:include>
</body>
</html>