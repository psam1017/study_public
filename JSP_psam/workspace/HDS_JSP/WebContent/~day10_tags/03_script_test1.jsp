<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag1</title>
</head>
<body>
	<%!int count = 3; %> <!-- 선언 -->
	<% count = 4; %> <!-- 사용 -->
	<%= count %> <!-- 출력. 이 값은 out.print 함수의 인수가 되기 때문에 세미콜론을 찍지 않는다. -->
</body>
</html>