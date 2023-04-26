<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ include file="dbconn.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="../resources/css/bootstrap.min.css">
<script src="../resources/js/validation.js"></script>
</head>
<body>

	<jsp:include page="market_header.jsp"/>

	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">상품 수정</h1>
			<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
		</div>
	</div>
	<%
		String productID = request.getParameter("productID");
		String sql = "SELECT * FROM product WHERE p_id = ?";
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, productID);
		rs = pstmt.executeQuery();
	
		while(rs.next()){
	%>
	<div class="container">
		<form name="newProduct" action="update_product_process.jsp" class="form-horizontal" method="post" enctype="multipart/form-data">
			<input type="hidden" name="productID" id="productID" value="<%=rs.getString("p_id")%>">
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="pName" id="pName" class="form-control" value="<%=rs.getString("p_name")%>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" id="unitPrice" class="form-control" value="<%=rs.getString("p_unitPrice")%>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-5">
					<textarea name="description" rows="2" cols="50" class="form-control">
					 <%=rs.getString("")%>
					</textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control" value="<%=rs.getString("p_manufacturer")%>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control" value="<%=rs.getString("p_category")%>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수량</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" id="unitsInStock" class="form-control" value="<%=rs.getString("p_unitsInStock")%>">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New" <% if(rs.getString("p_condition").equals("New")) out.print("checked");%>> 신규 상품
					<input type="radio" name="condition" value="Old" <% if(rs.getString("p_condition").equals("Old")) out.print("checked");%>> 중고 상품
					<input type="radio" name="condition" value="Refurbished" <% if(rs.getString("p_condition").equals("Refurbished")) out.print("checked");%>> 재생 상품
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-5">이미지</label>
				<div class="col-sm-5">
					<input type="file" name="productImage" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="button" class="btn byn-primary" onclick="checkAddProduct()">등록</button>
				</div>
			</div>
		</form>
	</div>
	
	<%
		}
		
		if(rs != null){
			rs.close();
		}
		if(pstmt != null){
			pstmt.close();
		}
		if(conn != null){
			conn.close();
		}
	%>
	
	<jsp:include page="market_footer.jsp"/>
</body>
</html>