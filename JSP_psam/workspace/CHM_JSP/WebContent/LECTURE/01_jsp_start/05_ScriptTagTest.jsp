<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그</title>
</head>
<body>
	<%-- Test1 : 전역변수와 메소드를 선언하고 출력 --%>
	<%!
		String str = "Hello, Java Server Pages";
		public String getString(String str){
			return str;
		}
	%>
	<%=getString(str)%>

	<%--
		Test2 : 스크립틀릿 태그로 지역변수를 만들고, 현재 날짜와 시간을 출력
		단, 디렉티브 태그를 사용하지 않고 Date 클래스를 가져오도록 한다.
	--%>
	<hr>
	<%
		java.util.Date date = new java.util.Date();
		out.print("Today's date is ... " + date);
	%>
	
	<%-- Test3 : 표현문 태그로 Calendar 클래스에 체이닝을 사용하여 날짜와 시간을 출력 --%>
	<hr>
	<%=java.util.Calendar.getInstance().getTime()%>
</body>
</html>
