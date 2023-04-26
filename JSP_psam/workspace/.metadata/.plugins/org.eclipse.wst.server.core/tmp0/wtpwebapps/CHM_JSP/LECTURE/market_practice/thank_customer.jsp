<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문완료</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	String cartId = session.getId();
	
	String shipping_cartId = "";
	String shipping_shppingDate = "";
	
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie c : cookies){
			String name = c.getName();

			switch(name){
				case "Shipping_cartId":
					shipping_cartId = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_shippingDate":
					shipping_shppingDate = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				default:
					break;
			}
		}
	}
%>

	<jsp:include page="market_header.jsp"/>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">주문완료</h1>
		</div>
	</div>
	
	<div class="container">
		<h2 class="alert alert-danger">주문해주셔서 감사합니다.</h2>
		<p> 주문은 <%= shipping_shppingDate %>에 배송될 예정입니다.
		<p> 주문번호 : <%= shipping_cartId %>
	</div>
	<div class="container">
		<p> <a href="market.jsp" class="btn btn-secondary"> &laquo; 상품 목록</a>
	</div>
</body>
</html>
<%
	session.invalidate();

	for(Cookie c : cookies){
		String name = c.getName();

		switch(name){
			case "Shipping_cartId":
				c.setMaxAge(0);
				break;
			case "Shipping_name":
				c.setMaxAge(0);
				break;
			case "Shipping_shippingDate":
				c.setMaxAge(0);
				break;
			case "Shipping_country":
				c.setMaxAge(0);
				break;
			case "Shipping_zipCode":
				c.setMaxAge(0);
				break;
			case "Shipping_addressName":
				c.setMaxAge(0);
				break;
			default:
				break;
		}
		response.addCookie(c);
	}
%>