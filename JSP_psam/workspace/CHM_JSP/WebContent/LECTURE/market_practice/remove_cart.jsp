<%@page import="java.util.ArrayList"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="_06_action_tags.market.dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String productId = request.getParameter("productID");
	if(productId == null || productId.trim().equals("")){
		response.sendRedirect("market.jsp");
		return;
	}
	
	ProductDAO dao = ProductDAO.getInstance();
	
	ProductDTO product = dao.getProductById(productId);
	if(product == null){
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	@SuppressWarnings("unchecked")
	ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) session.getAttribute("cartlist");
	cartList.remove(product);
	
	response.sendRedirect("cart.jsp");
%>