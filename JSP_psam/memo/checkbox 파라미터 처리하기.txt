<%@page import="mvc.dao.CartDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	CartDAO cartDAO = new CartDAO();
	String orderNo = session.getId();
	
	String[] cartIds = request.getParameterValues("chkID");
	
	for(String cartId : cartIds){
		cartDAO.deleteCartById(orderNo, Integer.parseInt(cartId));
	}
	
	response.sendRedirect("cart.jsp");
%>