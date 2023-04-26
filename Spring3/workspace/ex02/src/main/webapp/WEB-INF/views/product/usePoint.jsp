<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포인트 결제</title>
</head>
<body>
	<form action="/ex02/use" method="post">
		<input type="hidden" name="productName">
		<input type="hidden" name="productPrice">
		<table border="1" style="margin : 0 auto;">
			<tr>
				<th>선택</th>
				<th>상품명</th>
				<th>가격</th>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="1"></td>
				<td>오징어 땅콩</td>
				<td>3500</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="2"></td>
				<td>초코 우유</td>
				<td>1500</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="3"></td>
				<td>벌꿀 피자</td>
				<td>2800</td>
			</tr>
			<tr>
				<td><input type="radio" name="productNumber" value="4"></td>
				<td>샌드위치</td>
				<td>4500</td>
			</tr>
		</table>
		<br>
		<div style="text-align : center;">
			<input type="text" name="point" placeholder="사용할 포인트를 입력하세요." style="width : 200px;">
			<input type="submit" name="구매">
		</div>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.6.2.min.js"></script>
<script>
	let $temp;
	let productNumber = "${product.productNumber}";
	let productPrice = "${product.productPrice}";
	
	$("input[name='productNumber']").click(function(){
		const tags = $(this).closest("tr").children();
		
		$("input[name='productName']").val($(tags[1]).text());
		$("input[name='productPrice']").val($(tags[2]).text());
	});
	
	$(document).ready(function(){
		$("input[name='productNumber']").each(function(i, input){
			if($(input).val() == productNumber){
				const priceTag = $(input).closest("tr").children()[2];
				const trTag = $(input).closest("tr");
				
				$(trTag).css("background-color", "skyblue").css("color", "red");
				$(priceTag).text(productPrice);
			}
		});
	});
</script>
</html>
