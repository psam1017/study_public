<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag 실습</title>
</head>
<body>
<!-- 아래 모양과 같이 테이블 만들기 -->
<!-- 
	□
	□□
	□□□
	□□□□
	□□□□□
	□□□□
	□□□
	□□
	□
 -->
<%!
int total = 9; // total은 홀수가 되도록 할 것.
int mid = (total / 2) + 1;
%>

<%
out.print("<table border=1>");
for(int i = 0; i < total; i++){
	out.print("<tr>");
	if(i < mid){
		for(int j = 0; j < (i+1); j++){
			out.print("<td>" + (i+1) + ", " + (j+1) + "</td>");
		}
	}
	else{
		for(int j = 0; j < (total-i); j++){
			out.print("<td>" + (i+1) + ", " + (j+1) + "</td>");
		}
	}
	out.print("</tr>");
}
out.print("</table>");
%>

</body>
</html>