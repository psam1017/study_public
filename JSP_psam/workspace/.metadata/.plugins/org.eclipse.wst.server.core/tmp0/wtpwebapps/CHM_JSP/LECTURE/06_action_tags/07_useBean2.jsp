<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 태그</title>
</head>
<body>
	<!-- 
		자바빈즈의 의의 : 프론트는 계산과 메소드 호출만 하고, 백이 클래스를 생성하면서 각자의 영역을 구분한다.
	 -->
	<jsp:useBean id="bean" class="_06_action_tags.Calculator"/>
	<%= "5의 제곱 : " + bean.square(5) %>
</body>
</html>