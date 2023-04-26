<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int number = Integer.parseInt(request.getParameter("number"));
	
	for(int i = 1; i < 10; i++){
%>
		<%= number + " * " + i + " = " + (number * i)%>
		<%= "<br>" %>
<%
	}
%>