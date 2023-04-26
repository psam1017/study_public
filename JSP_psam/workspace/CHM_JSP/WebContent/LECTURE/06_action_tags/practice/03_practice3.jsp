<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션태그 실습</title>
</head>
<body>
	<jsp:useBean id="table" class="_06_action_tags.Table"/>
	<%
		for(String s : table.getTable(5)){
	%>
		<%= s + "<br>" %>
	<%
		}
	%>
</body>
</html>