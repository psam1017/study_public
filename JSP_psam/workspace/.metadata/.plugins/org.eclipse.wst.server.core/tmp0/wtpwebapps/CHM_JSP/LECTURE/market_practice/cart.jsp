<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<%
	String cartId = session.getId();
%>
	<jsp:include page="market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left"><a name="<%=cartId%>" href="" class="btn btn-danger removeAll">삭제하기</a></td>
					<td align="right"><a href="shipping_info.jsp?cartId=<%= cartId %>" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
		<div style="padding-top: 50px;">
			<table class="table table-hover">
				<tr>
					<th>상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				<%
				int sum = 0;
				@SuppressWarnings("unchecked")
				ArrayList<ProductDTO> cartList = (ArrayList<ProductDTO>) session.getAttribute("cartlist");
				if(cartList == null){
					cartList = new ArrayList<ProductDTO>();
					session.setAttribute("cartlist", cartList);
				}
				
				for(int i = 0; i < cartList.size(); i++){
					ProductDTO product = cartList.get(i);
					int total = product.getUnitPrice() * product.getQuantity();
					sum += total;
				%>
				<tr>
					<td><%=product.getProductID() %> - <%=product.getpName() %></td>
					<td><%= product.getUnitPrice() %></td>
					<td><%= product.getQuantity() %></td>
					<td><%= total %></td>
					<td><a name="<%= product.getProductID() %>" href="" class="badge badge-danger removeOne">삭제</a></td>
				</tr>
				<%
				}
				%>
				<tr>
					<th></th>
					<th></th>
					<th>총액</th>
					<th><%= sum %></th>
					<th></th>
				</tr>
			</table>
			<a href="market.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
		</div>
	</div>
		
	<jsp:include page="market_footer.jsp"/>
	
</body>
<script>
	const removeOne = document.querySelectorAll(".removeOne");
	const removeAll = document.querySelectorAll(".removeAll");
	
	for(let i = 0; i < removeOne.length; i++){
		removeOne[i].addEventListener("click", function(e){
			e.preventDefault();
			if(confirm("상품을 장바구니에서 삭제하시겠습니까?")){
				let productID = this.name;
				location.replace("remove_cart.jsp?productID=" + productID);
			}
		});
	}
	
	removeAll[0].addEventListener("click", function(e){
		e.preventDefault();
		if(confirm("상품을 장바구니에서 모두 삭제하시겠습니까?")){
			let cartId = this.name;
			location.replace("remove_all.jsp?cartId=" + cartId);
		}
	});
</script>
</html>