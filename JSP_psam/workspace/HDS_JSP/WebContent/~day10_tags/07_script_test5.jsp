<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag4</title>
</head>
<body>
	<!-- 3행 5열을 for문으로 테이블 만들기 -->
	
	<table border="1">
		<%
		for(int i = 1; i <= 3; i++){
			out.print("<tr>");
			for(int j = 1; j <= 5; j++){
				out.print("<td>"+ i + j +"</td>");
			}
			out.print("</tr>");
		}
		%>
	</table>
</body>
</html>