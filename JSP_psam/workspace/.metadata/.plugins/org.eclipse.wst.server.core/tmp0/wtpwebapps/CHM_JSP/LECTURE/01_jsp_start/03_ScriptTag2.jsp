<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 태그</title>
</head>
<body>
	<%!
		// 선언문 태그 사용 예시 : 전역변수를 선언한다.
		int global = 0;
	%>
	<p>Global Count is ...
	<%
		global++;
		out.print(global); // 전역변수 1 증가. 새로고침할 때마다 숫자가 증가한다.
		out.print("<br>" + "Local Count is ... ");
		
		int local = 0;
		local++;
		out.print(local);
	%>
	</p>
</body>
</html>
