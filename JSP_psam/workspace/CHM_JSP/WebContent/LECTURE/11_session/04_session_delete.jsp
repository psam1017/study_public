<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	// 관련된 세션을 종료
	// session.invalidate();

	session.removeAttribute("id");
	session.removeAttribute("pw");
	
	response.sendRedirect("03_session_check.jsp");
%>