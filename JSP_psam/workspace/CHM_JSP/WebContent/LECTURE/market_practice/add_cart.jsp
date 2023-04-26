<%@page import="java.util.ArrayList"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="_06_action_tags.market.dao.ProductDAO"%>
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
		response.sendRedirect("market.jsp");
		return;
	}
	
	ProductDAO dao = ProductDAO.getInstance();
	
	ProductDTO product = dao.getProductById(productID);
	if(product == null){
		response.sendRedirect("exceptionNoProductId.jsp");
	}
	
	@SuppressWarnings("unchecked")
	ArrayList<ProductDTO> list = (ArrayList<ProductDTO>)session.getAttribute("cartlist");
	if(list == null){
		list = new ArrayList<ProductDTO>();
		session.setAttribute("cartlist", list);
	}
	
	int cnt = 0; // int가 아니라 boolean으로 변경해야 함
	ProductDTO goodsQnt = new ProductDTO();
	for(int i = 0; i < list.size(); i++){
		goodsQnt = list.get(i);
		if(goodsQnt.getProductID().equals(productID)){
			cnt++;
			int orderQuantity = goodsQnt.getQuantity() + 1;
			goodsQnt.setQuantity(orderQuantity);
		}
	}
	
	if(cnt == 0){
		product.setQuantity(1);
		list.add(product);
	}
	
	response.sendRedirect("product.jsp?productID=" + productID);
%>
</body>
</html>