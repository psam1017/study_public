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
		useBean 액션 태그에 Date 클래스를 사용하여 현재 날짜와 시간 출력
		
		1. 자바빈즈에 Date 클래스를 사용할 수 있도록 useBean 액션 태그를 작성.
		2. 표현문 태그로 문자열을 출력하도록 스크립틀릿 태그를 작성.
		3. useBean 액션 태그에 id 속성 값으로 현재 날짜와 시간을 출력하도록 표현문 태그를 작성.
	-->
	<jsp:useBean id="date" class="java.util.Date">
	<p><%= "오늘 날짜 및 시간" %></p>
	<p><%= date %></p>
	</jsp:useBean>
</body>
</html>