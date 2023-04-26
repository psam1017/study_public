<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<h1 class="display-3">상품등록</h1>
			<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
		</div>
	</div>
	<div class="container">
		<form name="newProduct" action="add_product_process.jsp" class="form-horizontal" method="post" enctype="multipart/form-data">
			<div class="form-group row">
				<label class="col-sm-2">상품 코드</label>
				<div class="col-sm-2">
					<input type="text" name="productID" id="productID" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품명</label>
				<div class="col-sm-3">
					<input type="text" name="pName" id="pName" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 가격</label>
				<div class="col-sm-3">
					<input type="text" name="unitPrice" id="unitPrice" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상세정보</label>
				<div class="col-sm-5">
					<textarea name="description" rows="2" cols="50" class="form-control"></textarea>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">제조사</label>
				<div class="col-sm-3">
					<input type="text" name="manufacturer" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상품 분류</label>
				<div class="col-sm-3">
					<input type="text" name="category" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">재고 수량</label>
				<div class="col-sm-3">
					<input type="text" name="unitsInStock" id="unitsInStock" class="form-control">
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2">상태</label>
				<div class="col-sm-5">
					<input type="radio" name="condition" value="New"> 신규 상품
					<input type="radio" name="condition" value="Old"> 중고 상품
					<input type="radio" name="condition" value="Refurbished"> 재생 상품
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
	
	<jsp:include page="market_footer.jsp"/>
</body>
</html>