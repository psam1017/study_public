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
		<% for(int i = 0; i < members.size(); i++) { %>
		<jsp:setProperty property="name" name="vo" value="<%= members.get(i).getName() %>"/>
		<jsp:setProperty property="birthday" name="vo" value="<%= members.get(i).getBirthday() %>"/>
		<tr>
			<td><jsp:getProperty property="name" name="vo"/></td>
			<td><jsp:getProperty property="birthday" name="vo"/></td>
		</tr>
		<% } %>
	</table>
	
</body>
</html>