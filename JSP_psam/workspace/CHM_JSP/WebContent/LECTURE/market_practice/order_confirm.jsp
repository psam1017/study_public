<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	String cartId = session.getId();
	
	String shipping_cartId = "";
	String shipping_name = "";
	String shipping_shppingDate = "";
	String shipping_country = "";
	String shipping_zipCode = "";
	String shipping_addressName = "";
	
	Cookie[] cookies = request.getCookies();
	
	if(cookies != null){
		for(Cookie c : cookies){
			String name = c.getName();

			switch(name){
				case "Shipping_cartId":
					shipping_cartId = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_name":
					shipping_name = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_shippingDate":
					shipping_shppingDate = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_country":
					shipping_country = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_zipCode":
					shipping_zipCode = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				case "Shipping_addressName":
					shipping_addressName = URLDecoder.decode(c.getValue(), "UTF-8");
					break;
				default:
					break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문정보</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>


	<jsp:include page="market_header.jsp"/>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">주문정보</h1>
		</div>
	</div>
	
	<div class="container alert alert-info">
		<div class="text-center">
			<h1>영수증</h1>
		</div>
		<div class="row justify-content-between">
			<div class="col-4" align="left">
				<strong>배송 주소</strong>
				성명 : <%= shipping_name%> <br>
				우편번호 : <%= shipping_zipCode%> <br>
				주소 : <%= shipping_addressName%> (<%= shipping_country%>) <br>
			</div>
			<div class="col-4" align="right">
				<p> <em>배송일 : <%= shipping_shppingDate %></em>
			</div>
		</div>
		<div>
			<table class="table table-hover">
				<tr>
					<th class="text-center">상품</th>
					<th class="text-center">#</th>
					<th class="text-center">가격</th>
					<th class="text-center">소계</th>
				</tr>
				<%
				int sum = 0;
				@SuppressWarnings("unchecked")
				ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) session.getAttribute("cartlist");
				if(cartList == null){
					cartList = new ArrayList<ProductDTO>();
				}
				
				for(int i = 0; i < cartList.size(); i++){
					ProductDTO product = cartList.get(i);
					int total = product.getUnitPrice() * product.getQuantity();
					sum += total;
				%>
				<tr>
					<td class="text-center"><em><%=product.getpName() %></em></td>
					<td class="text-center"><%= product.getUnitPrice() %></td>
					<td class="text-center"><%= product.getQuantity() %></td>
					<td class="text-center"><%= total %>원</td>
				</tr>
				<%
				}
				%>
				<tr>
					<td></td>
					<td></td>
					<td class="text-right"><strong>총액 : </strong></td>
					<td class="text-center text-danger"><strong><%=sum %></strong></td>
				</tr>
			</table>
			
			<a href="shipping_info.jsp?cartId=<%=shipping_cartId%>" class="btn btn-secondary" role="button">이전으로</a>
			<a href="thank_customer.jsp" class="btn btn-success" role="button">주문완료</a>
			<a href="check_cancel.jsp" class="btn btn-secondary" role="button">주문취소</a>
		</div>
	</div>
</body>
</html>