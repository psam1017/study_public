<%@page import="com.jspex.beans.MemberVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:useBean class="com.jspex.beans.MemberVO" id="vo"></jsp:useBean> <!-- HTML에서 스크립트 태그에 의존하지 않고, MemberVO를 객체처럼 사용 -->
<jsp:useBean class="com.jspex.beans.MemberDAO" id="dao"></jsp:useBean>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
	<%
		ArrayList<MemberVO> members = dao.select("박성민");
	%>
	<table border=1>
	<% for(int i = 0; i < members.size(); i++){ %>
		<tr>
			<td><%= members.get(i).getName() %></td>
			<td><%= members.get(i).getBirthday() %></td>
		</tr>
	<% } %>
	</table>
		
	<%--
		ArrayList<MemberVO> members = dao.select("박성민");
		out.print("<table border=1>");
		for(int i = 0; i < members.size(); i++){
			out.print("<tr>");
				out.print("<td>" + members.get(i).getName() + "</td>");
				out.print("<td>" + members.get(i).getBirthday() + "</td>");
			out.print("</tr>");
		}
		out.print("</table>");
	--%>
	
</body>
</html>