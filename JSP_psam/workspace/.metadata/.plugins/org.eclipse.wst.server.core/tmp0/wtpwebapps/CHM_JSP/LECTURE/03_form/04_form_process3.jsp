<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table{
		border-spacing: 0px;
	}
	td{
		width: 300px;
		border: 1px solid black;
	}
</style>
<title>폼 태그 값 받기</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	
		out.print("<table>");
		Enumeration<String> paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()){

			String name = (String)paramNames.nextElement();
			out.print("<tr><td>" + name + "</td>");

			String[] value = request.getParameterValues(name);
			out.print("<td>");
			for(int i = 0; i < value.length; i++){
				out.print(" " + value[i]);
			}
			out.print("</td></tr>");
		}
		out.print("</table>");
	%>
</body>
</html>
