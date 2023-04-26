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
	<table border="1" style="margin : 0 auto;">
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>상품 정상가</th>
			<th>할인률 적용가</th>
			<th>적용된 할인률</th>
		</tr>
		<tr>
			<td><c:out value="${product.productNumber}" /></td>
			<td><c:out value="${product.productName}" /></td>
			<td><c:out value="${originPrice}" />원</td>
			<td><c:out value="${product.productPrice}" />원</td>
			<td><c:out value="${product.discountRate}" />%</td>
		</tr>
	</table>
	<form action="/ex02/usePoint" method="post" name="discountForm">
		<input type="hidden" name="productNumber" value="${product.productNumber}">
		<input type="hidden" name="productPrice" value="${product.productPrice}">
		<input type="submit" value="포인트 결제" style="display : block; margin : 0 auto;">
	</form>
	<br>
	<input type="button" onclick="location.href='/ex02/sale'" value="상품 할인 변경하기" style="display : block; margin : 0 auto;">
</body>
</html>
