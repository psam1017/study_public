<%@page import="mvc.dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
new CartDAO().deleteCartAll(session.getId());
response.sendRedirect("cart.jsp");
%>