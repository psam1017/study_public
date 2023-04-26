<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 내역</title>
</head>
<body>
	<table border="1" style="margin : 0 auto;">
		<caption>결제 내역</caption>
		<tr>
			<th>상품 번호</th>
			<th>상품명</th>
			<th>상품 가격</th>
			<th>사용한 포인트</th>
			<th>사용한 현금</th>
		</tr>
		<tr>
			<td><c:out value="${product.productNumber}"></c:out></td>
			<td><c:out value="${product.productName}"></c:out></td>
			<td><c:out value="${product.productPrice}"></c:out></td>
			<td><c:out value="${point}"></c:out></td>
			<td><c:out value="${cash}"></c:out></td>
		</tr>
	</table>
</body>
</html>
