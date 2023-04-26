<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page errorPage="./address_book_error.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>주소록:목록화면</title>
	<link rel="stylesheet" href="../resources/css/address_book.css" type="text/css" media="screen" />
</head>
<body>
	<div align="center">
		<h2>주소록:작성화면</h2>
		<hr>
		[<a href="./address_book_control.jsp?action=list">주소록 목록</a>]으로<br>
		<form name="frmInsert" method="post" action="./address_book_control.jsp">
			<input type="hidden" name="action" value="insert">
			<table border="1">
				<tr>
					<th>이름</th>
					<th>이메일</th>
					<th>전화번호</th>
					<th>생일</th>
					<th>회사</th>
					<th>메모</th>
				</tr>
				<tr>
					<td><input type="text" name="name" maxlength="100"></td>
					<td><input type="email" name="email" maxlength="100"></td>
					<td><input type="text" name="tel" maxlength="100"></td>
					<td><input type="date" name="birth" maxlength="100"></td>
					<td><input type="text" name="comdept" maxlength="100"></td>
					<td><input type="text" name="memo" maxlength="100"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="저장">
		</form>
	</div>
</body>
</html>