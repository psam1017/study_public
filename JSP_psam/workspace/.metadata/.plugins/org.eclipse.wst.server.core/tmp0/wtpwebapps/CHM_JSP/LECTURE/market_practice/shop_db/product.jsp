<%@page import="_06_action_tags.market.dao.ProductDAO"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="exceptionNoProductId.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="../market_header.jsp"/>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품정보</h1>
		</div>
	</div>
	<%
		String productID = request.getParameter("productID");
		ProductDAO dao = ProductDAO.getInstance();
		ProductDTO product = dao.getProductById(productID);
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-5">
				<img src="${pageContext.request.contextPath}/LECTURE/resources/images/<%=product.getFilename()%>" style="width : 100%;"/>
			</div>
			<div class="col-md-6">
				<h3><%= product.getpName() %></h3>
				<p> <%= product.getDescription() %>
				<p> 상품 코드 : <span class="badge badge-danger"><%= product.getProductID() %></span>
				<p> 제조사 : <%= product.getManufacturer() %>
				<p> 분류 :  <%= product.getCategory() %>
				<p> 재고 수 : <%= product.getUnitsInStock() %>
				<h4><%= product.getUnitPrice() %>원</h4>
				<p>
				<form name="addForm" action="" method="post">
					<a href="./add_cart.jsp?productID=<%=product.getProductID()%>" class="btn btn-info" onclick="addToCart()">장바구니에 추가 &raquo;</a>
					<a href="cart.jsp" class="btn btn-warning">장바구니 &raquo;</a>
					<a href="market.jsp">상품 목록 &raquo;</a>
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="../market_footer.jsp"/>
	
</body>
<script>
	function addToCart(){
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){
			document.addForm.submit();
		}
		else{
			document.addForm.reset();
		}
	}
</script>
</html>