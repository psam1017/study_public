<%@page import="mvc.dao.CartDAO"%>
<%@page import="mvc.dao.ProductDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품추가</title>
</head>
<body>
<%
	String productID = request.getParameter("productID");
	if(productID == null || productID.trim().equals("")){
		response.sendRedirect("market2.jsp");
		return;
	}
	
	ProductDAO dao = new ProductDAO();
	
	ProductDTO product = dao.getProductById(productID);
	if(product == null){
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	String orderNo = session.getId();
	String memberId = (String) session.getAttribute("sessionID");
	
	CartDAO cartDao = new CartDAO();
	
	boolean flag = cartDao.updateCart(product, orderNo, memberId);
	
	response.sendRedirect("product.jsp?productID=" + productID);
%>
</body>
</html>