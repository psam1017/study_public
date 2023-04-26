<%@page import="mvc.dto.CartDTO"%>
<%@page import="mvc.dao.CartDAO"%>
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
	@SuppressWarnings("unchecked")
	ArrayList<CartDTO> cartArrayList = (ArrayList<CartDTO>)request.getAttribute("cartArrayList");
	String cartId = session.getId();
%>
	<jsp:include page="../market_header.jsp"/>
	
	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row">
			<table width="100%">
				<tr>
					<td align="left">
						<span class="btn btn-danger" onclick="deleteCart()">전체삭제</span>
						<span class="btn btn-danger" onclick="removeCartSel()">선택삭제</span>
					</td>
					<td align="right"><a href="shipping_info.jsp?cartId=<%= cartId %>" class="btn btn-success">주문하기</a></td>
				</tr>
			</table>
		</div>
		<div style="padding-top: 50px;">
		<form name="frmCart">
			<input type="hidden" name="id">
			<input type="text" name="chkdID">
			  <table class="table table-hover">
				<tr>
					<th><input type="checkbox" name="chkAll" onclick="setChkAll()">상품</th>
					<th>가격</th>
					<th>수량</th>
					<th>소계</th>
					<th>비고</th>
				</tr>
				<%--
				<%
				int sum = 0;
				CartDAO cartDAO = new CartDAO();
				String orderNO = session.getId();
				ArrayList<CartDTO> cartArrayList = cartDAO.getCartList(orderNO);
				for(CartDTO cart : cartArrayList){
					int total = cart.getUnitPrice() * cart.getCnt();
					sum += total;
				%>
				--%>
				<%
				int sum = 0;
				for(CartDTO cart : cartArrayList){
					int total = cart.getUnitPrice() * cart.getCnt();
					sum += total;
				%>
				<tr>
					<td><input type="checkbox" name="chkID" value="<%= cart.getCartId() %>" onclick="setChkAlone(this);">
					<%=cart.getProductId() %> - <%=cart.getName() %></td>
					<td><%= cart.getUnitPrice() %></td>
					<td><%= cart.getCnt() %></td>
					<td><%= total %></td>
					<td><span class="badge badge-danger btn" onclick="removeCartById('<%=cart.getCartId()%>')">삭제</span></td>
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
			</form>
			<a href="market.jsp" class="btn btn-secondary"> &laquo; 쇼핑 계속하기</a>
		</div>
	</div>
		
	<jsp:include page="../market_footer.jsp"/>
	
</body>
<script src="../../resources/js/check_system.js"></script>
<script>
	window.onload = function(){
		document.frmCart.chkAll.checked = true;
		setChkAll();
	}
	function frmName(){
		return document.frmCart;
	}
</script>
<script>
	const frm = document.frmCart;
	let removeCartById = function(ID){
		if(confirm("해당 상품을 삭제하시겠습니까?")){
			location.href = "removeCart.jsp?id=" + ID;
		}
	}
	let removeCartSel = function(){
		if(confirm("선택한 상품을 삭제하시겠습니까?")){
			frm.action = "removeCartSel.jsp";
			frm.submit();
		}
	}
	let deleteCart = function(){
		if(confirm("전체 삭제하시겠습니까?")){
			location.href = "deleteCart.jsp";
		}
	}
</script>
</html>