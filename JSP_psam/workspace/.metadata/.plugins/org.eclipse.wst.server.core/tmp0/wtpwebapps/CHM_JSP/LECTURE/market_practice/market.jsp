<%@page import="_06_action_tags.market.dao.ProductDAO"%>
<%@page import="_06_action_tags.market.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>

	<jsp:include page="market_header.jsp"/>
	
	<%
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductDTO> listOfProducts = dao.getAllProducts();
	%>

	<div class="jumbotron">
		<div class="container text-center">
			<h1 class="display-3">상품목록</h1>
		</div>
	</div>
	<div class="container">
		<div class="row" align="center">
			<%
				for(int i = 0; i < listOfProducts.size(); i++){
					ProductDTO product = listOfProducts.get(i);
			%>
			<div class="col-md-4">
				<img src="${pageContext.request.contextPath}/LECTURE/resources/images/<%=product.getFilename()%>" style="width : 100%;"/>
				<h3><%= product.getpName() %></h3>
				<p> <%= product.getDescription() %>
				<p> <%= product.getUnitPrice() %>원
				<br>
				<a href="product.jsp?productID=<%=product.getProductID()%>">
					<span class="btn btn-secondary" role="button">
						상세정보 보기
					</span>
				</a>
			</div>
			<%
				}
			%>
		</div>
	</div>
	<div class="container">
		<div class="btn btn-primary">
			<a href="add_product.jsp" style="color: black;">상품 등록하기</a>
		</div>
	</div>
	<jsp:include page="market_footer.jsp"/>
</body>
</html>