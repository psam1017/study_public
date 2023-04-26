<%@page import="java.util.ArrayList"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="_06_action_tags.market.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.removeAttribute("cartlist");
	
	response.sendRedirect("cart.jsp");
%>