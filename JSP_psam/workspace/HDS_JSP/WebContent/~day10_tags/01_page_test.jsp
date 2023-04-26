<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    errorPage="myErrorPage.jsp"
    info="Date 클래스를 이용한 날짜 출력"%>
<!--
	errorPage : 에러가 발생하는 해당 페이지로 이동
	info : 현재 페이지의 정보를 입력
 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 디렉티브 태그 예제</title>
</head>
<body>
	Today is : <%=new Date()%>
	<%
		String data = null;
		data.charAt(0); // 의도적으로 에러 발생
	%>
</body>
</html>