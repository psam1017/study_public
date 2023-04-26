<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세일 항목 변경</title>
</head>
<body>
	<form action="/ex02/change" method="post">
		<input type="hidden" name="productName">
		<input type="hidden" name="productPrice">
		<input type="hidden" name="discountRate">
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
		<div style="text-align: center;">
			<button class="rate" type="button" data-rate="10">10%</button>
			<button class="rate" type="button" data-rate="30">30%</button>
			<button class="rate" type="button" data-rate="60">60%</button>
			<button class="rate" type="button" data-rate="90">90%</button>
			<button style="display : block; margin: 10px auto; width : 180px;">적용</button>
		</div>
	</form>
</body>
<script src="https://code.jquery.com/jquery-3.6.2.min.js"></script>
<script>
	let $temp;
	$("button.rate").click(function(e){
		if($temp){
			$temp.css("color", "black");
		}
		$temp = $(this);
		$(this).css("color", "hotpink");
		// data 함수를 사용하여 rate를 전달
		// data 함수를 사용하기 위해서는 위처럼 data-xxx 형식을 지켜서 속성으로 지정해야 한다.
		$("input[name='discountRate']").val($(this).data("rate"));
	});
	
	$("input[name='productNumber']").click(function(){
		const tags = $(this).closest("tr").children()
		
		$("input[name='productName']").val($(tags[1]).text());
		$("input[name='productPrice']").val($(tags[2]).text());
	});
	
</script>
</html>
