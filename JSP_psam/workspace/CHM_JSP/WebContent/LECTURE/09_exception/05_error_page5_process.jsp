<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	try{
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		out.print(num1 + " / " + num2 + " = " + (num1 / num2));	
	}
	catch(NumberFormatException e){
		RequestDispatcher dispatcher = request.getRequestDispatcher("error_exception_handling.jsp");
		dispatcher.forward(request, response);
	}
%>