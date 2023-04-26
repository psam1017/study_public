<%@page import="mvc.dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int cartId = Integer.parseInt(request.getParameter("id"));
String orderNo = session.getId();

CartDAO cartDAO = new CartDAO();
cartDAO.deleteCartById(orderNo, cartId);

response.sendRedirect("cart.jsp");
%>