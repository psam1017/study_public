<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 param 테스트</title>
</head>
<body>
	<h3>param 액션 태그</h3>
	
	<!--
	1. name은 key 값에 해당한다.
	2. value에 한글을 사용하였으므로 상단 3번 줄과 같이 requset의 인코딩을 설정해줘야 한다.
	-->
	<jsp:forward page="18_paramP.jsp">
		<jsp:param value="admin" name="id"/>
		<jsp:param value="관리자" name="name"/>
	</jsp:forward>
</body>
</html>