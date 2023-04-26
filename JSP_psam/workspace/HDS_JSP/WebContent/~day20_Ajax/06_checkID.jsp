<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	if(request.getParameter("id").equals("psm1234")){
		out.print("실패");
	} else{
		out.print("성공");
	}
%>